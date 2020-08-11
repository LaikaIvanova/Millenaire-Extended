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

public class ItemBookFrankSigmarFive extends Item implements IHasModel {
	public ItemBookFrankSigmarFive(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		InitItems.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
            tooltip.add("21th of September, 1009");
            tooltip.add("");
            tooltip.add("I've talked with the major and apparently they want to build a huge monument! It looks like some other merchant, a stranger who came to this village a while ago has to bring all the other villages around here together to build this!");
    }
	
	@Override
	public void registerModels() {
		MillenaireExtended.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
