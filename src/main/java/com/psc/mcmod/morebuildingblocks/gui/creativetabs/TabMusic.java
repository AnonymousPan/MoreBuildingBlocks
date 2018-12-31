package com.psc.mcmod.morebuildingblocks.gui.creativetabs;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.blocks.BlocksInstance;
import com.psc.mcmod.morebuildingblocks.items.ItemsInstance;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabMusic extends CreativeTabs {

	public TabMusic() {
		super("mbbTabMusic");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		return Items.record_far;
	}

}
