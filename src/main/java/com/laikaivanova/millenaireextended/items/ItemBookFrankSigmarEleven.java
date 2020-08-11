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

public class ItemBookFrankSigmarEleven extends Item implements IHasModel {
	public ItemBookFrankSigmarEleven(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		InitItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
            tooltip.add("8th of April, 1010");
            tooltip.add("");
            tooltip.add("They made progress on the huge monument. Notre Dame is coming along nicely. I am not sure about how long it will take but eventually they rebuild the entire monument in this world.");
            tooltip.add("");
            tooltip.add("I am impressed.");
    }
	
	@Override
	public void registerModels() {
		MillenaireExtended.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
