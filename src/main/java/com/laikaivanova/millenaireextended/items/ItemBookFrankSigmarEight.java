package com.laikaivanova.millenaireextended.items;

import java.util.List;

import com.laikaivanova.millenaireextended.MillenaireExtended;
import com.laikaivanova.millenaireextended.common.IHasModel;
import com.laikaivanova.millenaireextended.init.InitItems;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBookFrankSigmarEight extends Item implements IHasModel {
	public ItemBookFrankSigmarEight(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		InitItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
           tooltip.add("24th of December, 1009");
           tooltip.add("");
           tooltip.add("The year is almost over and I'm still stuck here. I tried gathering more information about the Alchemist but everything I know so far is that he must live in the mountains. But what mountains? Where do I have to go?");
    }
	
	@Override
	public void registerModels() {
		MillenaireExtended.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
