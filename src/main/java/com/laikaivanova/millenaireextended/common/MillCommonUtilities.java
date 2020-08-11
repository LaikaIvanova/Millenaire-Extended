/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  com.google.common.collect.Multimap
 *  net.minecraft.block.Block
 *  net.minecraft.block.state.IBlockState
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.SharedMonsterAttributes
 *  net.minecraft.entity.ai.attributes.AttributeModifier
 *  net.minecraft.entity.ai.attributes.IAttribute
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.init.Blocks
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.inventory.IInventory
 *  net.minecraft.inventory.Slot
 *  net.minecraft.item.Item
 *  net.minecraft.item.ItemStack
 *  net.minecraft.nbt.NBTBase
 *  net.minecraft.nbt.NBTTagCompound
 *  net.minecraft.nbt.NBTTagList
 *  net.minecraft.util.EnumParticleTypes
 *  net.minecraft.util.ResourceLocation
 *  net.minecraft.world.World
 *  net.minecraft.world.storage.ISaveHandler
 *  net.minecraft.world.storage.SaveHandler
 *  net.minecraftforge.fml.common.Loader
 *  net.minecraftforge.fml.relauncher.ReflectionHelper
 */
package com.laikaivanova.millenaireextended.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.Random;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

@SuppressWarnings("deprecation")
public class MillCommonUtilities {
    @SuppressWarnings("unused")
	private static final String MILLENAIRE_ORG_ROOT = "http://millenaire.org";
    public static Random random = new Random();
    private static File baseDir = null;
    private static File customDir = null;

    public static boolean chanceOn(int i) {
        return MillCommonUtilities.getRandom().nextInt(i) == 0;
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; ++i) {
                boolean success = MillCommonUtilities.deleteDir(new File(dir, children[i]));
                if (success) continue;
                return false;
            }
        }
        return dir.delete();
    }


    public static String getCardinalDirectionStringFromAngle(int angle) {
        if ((angle %= 360) < 0) {
            angle += 360;
        }
        if (angle < 22 || angle > 338) {
            return "south";
        }
        if (angle < 68) {
            return "south-west";
        }
        if (angle < 112) {
            return "west";
        }
        if (angle < 158) {
            return "north-west";
        }
        if (angle < 202) {
            return "north";
        }
        if (angle < 248) {
            return "north-east";
        }
        if (angle < 292) {
            return "east";
        }
        return "south-east";
    }

    public static Method getDrawItemStackInventoryMethod(GuiContainer gui) {
        return ReflectionHelper.findMethod(GuiContainer.class, (String)"drawItemStack", (String)"func_146982_a", (Class[])new Class[]{ItemStack.class, Integer.TYPE, Integer.TYPE, String.class});
    }

    public static Method getDrawSlotInventoryMethod(GuiContainer gui) {
        return ReflectionHelper.findMethod(GuiContainer.class, (String)"drawSlot", (String)"func_146977_a", (Class[])new Class[]{Slot.class});
    }

    public static File getExportDir() {
        File exportDir = new File(MillCommonUtilities.getMillenaireCustomContentDir(), "exports");
        if (!exportDir.exists()) {
            exportDir.mkdirs();
        }
        return exportDir;
    }  

    public static File getMillenaireContentDir() {
        if (baseDir == null) {
            baseDir = new File(MillCommonUtilities.getModsDir(), "millenaire");
        }
        return baseDir;
    }

    public static File getMillenaireCustomContentDir() {
        if (customDir == null) {
            customDir = new File(MillCommonUtilities.getModsDir(), "millenaire-custom");
        }
        return customDir;
    }
    
    public static File getMillenaireExtendedContentDir() {
        if (customDir == null) {
            customDir = new File(MillCommonUtilities.getModsDir(), "millenaire-extended");
        }
        return customDir;
    }

    public static File getMillenaireHelpDir() {
        return new File(MillCommonUtilities.getMillenaireContentDir(), "help");
    }

    public static File getModsDir() {
        return new File(Loader.instance().getConfigDir().getParentFile(), "mods");
    }

    public static int getPriceColourMC(int price) {
        if (price >= 4096) {
            return 14;
        }
        if (price >= 64) {
            return 15;
        }
        return 6;
    }

    public static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    @SuppressWarnings("resource")
	public static BufferedReader getReader(File file) throws UnsupportedEncodingException, FileNotFoundException {
        return new BufferedReader(new InputStreamReader((InputStream)new FileInputStream(file), "UTF8"));
    }

    public static String getShortPrice(int price) {
        String res = "";
        if (price >= 4096) {
            res = (int)Math.floor(price / 4096) + "o ";
            price %= 4096;
        }
        if (price >= 64) {
            res = res + (int)Math.floor(price / 64) + "a ";
            price %= 64;
        }
        if (price > 0) {
            res = res + price + "d";
        }
        return res.trim();
    }

    public static void initRandom(int seed) {
        random = new Random(seed);
    }

    public static int[] packLong(long nb) {
        return new int[]{(int)(nb >> 32), (int)nb};
    }

    public static boolean probability(double probability) {
        return MillCommonUtilities.getRandom().nextDouble() < probability;
    }

    public static int randomInt(int max) {
        return MillCommonUtilities.getRandom().nextInt(max);
    }

    public static long randomLong() {
        return MillCommonUtilities.getRandom().nextLong();
    }

    public static int readInteger(String line) throws Exception {
        int res = 1;
        for (String s : line.trim().split("\\*")) {
            res *= Integer.parseInt(s);
        }
        return res;
    }

    public static long unpackLong(int nb1, int nb2) {
        return (long)nb1 << 32 | (long)nb2 & 0xFFFFFFFFL;
    }

    public static interface WeightedChoice {
        public int getChoiceWeight(EntityPlayer var1);
    }

    public static class VillageInfo
    implements Comparable<VillageInfo> {
        public String textKey;
        public String[] values;
        public int distance;

        @Override
        public int compareTo(VillageInfo arg0) {
            return arg0.distance - this.distance;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof VillageInfo)) {
                return false;
            }
            return this.distance == ((VillageInfo)o).distance;
        }

        public int hashCode() {
            return super.hashCode();
        }
    }

    public static class PrefixExtFileFilter
    implements FilenameFilter {
        String ext = null;
        String prefix = null;

        public PrefixExtFileFilter(String pref, String ext) {
            this.ext = ext;
            this.prefix = pref;
        }

        @Override
        public boolean accept(File file, String name) {
            if (!name.toLowerCase().endsWith("." + this.ext)) {
                return false;
            }
            if (!name.toLowerCase().startsWith(this.prefix)) {
                return false;
            }
            return !name.startsWith(".");
        }
    }

    public static class ExtFileFilter
    implements FilenameFilter {
        String ext = null;

        public ExtFileFilter(String ext) {
            this.ext = ext;
        }

        @Override
        public boolean accept(File file, String name) {
            if (!name.toLowerCase().endsWith("." + this.ext)) {
                return false;
            }
            return !name.startsWith(".");
        }
    }

    public static class BonusThread
    extends Thread {
        String login;

        public BonusThread(String login) {
            this.login = login;
        }

    }

}

