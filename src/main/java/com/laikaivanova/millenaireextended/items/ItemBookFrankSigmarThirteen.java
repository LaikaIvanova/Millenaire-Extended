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

public class ItemBookFrankSigmarThirteen extends Item implements IHasModel {
	public ItemBookFrankSigmarThirteen(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		InitItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
            tooltip.add("15th of June, 1010");
            tooltip.add("");
            tooltip.add("I've been here for over a year now and the time has come. The time has come to go on this journey and find the Alchemist. I am going to leave my notes here for others who might wanna follow me on my journey. If you read this, I am long gone. Follow me so we can find out together what the secrets of this world are.");
            tooltip.add("");
            tooltip.add("Farewell, dear reader.");
    }
	
	@Override
	public void registerModels() {
		MillenaireExtended.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
