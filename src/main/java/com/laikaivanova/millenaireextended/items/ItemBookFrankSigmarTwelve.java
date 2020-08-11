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

public class ItemBookFrankSigmarTwelve extends Item implements IHasModel {
	public ItemBookFrankSigmarTwelve(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		InitItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
            tooltip.add("1th of May, 1010");
            tooltip.add("");
            tooltip.add("I found it! I found the location of the Alchemist! It's in the far east mountains! I have to prepare for this journey as all men around here are helping with the monument. I have to go alone on this long journey to find out what this world is and why we are here.");
    }
	
	@Override
	public void registerModels() {
		MillenaireExtended.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
