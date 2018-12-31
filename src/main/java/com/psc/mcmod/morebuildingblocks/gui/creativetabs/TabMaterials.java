package com.psc.mcmod.morebuildingblocks.gui.creativetabs;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.blocks.BlocksInstance;
import com.psc.mcmod.morebuildingblocks.items.ItemsInstance;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabMaterials extends CreativeTabs {

	public TabMaterials() {
		super("mbbTabMaterials");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		return ItemsInstance.itemIronStick;
	}

}
