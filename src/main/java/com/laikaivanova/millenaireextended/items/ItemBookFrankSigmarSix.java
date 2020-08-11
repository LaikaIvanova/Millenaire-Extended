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

public class ItemBookFrankSigmarSix extends Item implements IHasModel {
	public ItemBookFrankSigmarSix(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		InitItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
            tooltip.add("5th of October, 1009");
            tooltip.add("");
            tooltip.add("The weather around here should get colder now, but it still looks like summer. The folks around here told me that there are no season in this world. I still haven't gotten an answer to all this.");
    }
	
	@Override
	public void registerModels() {
		MillenaireExtended.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
