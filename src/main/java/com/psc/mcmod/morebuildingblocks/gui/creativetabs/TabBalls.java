package com.psc.mcmod.morebuildingblocks.gui.creativetabs;

import java.util.List;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.blocks.BlocksInstance;
import com.psc.mcmod.morebuildingblocks.items.ItemsInstance;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TabBalls extends CreativeTabs {

	public TabBalls() {
		super("mbbTabBalls");
		// TODO Auto-generated constructor stub
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlocksInstance.blockBall);
	}

	@Override
	public void displayAllReleventItems(List list)
	{
		for(int i = 0;i < 16;i++)
		{
			list.add(new ItemStack(Item.getItemFromBlock(BlocksInstance.blockBall),0,i));
		}
	}
}
