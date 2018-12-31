package com.psc.mcmod.morebuildingblocks.blocks;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BlockSmallStoneBrick extends Block {
	
	public BlockSmallStoneBrick(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

public static final String blockID = "blockSmallStoneBrick";
	
	public static BlockSmallStoneBrick block = new BlockSmallStoneBrick(Material.rock);
	
	public static Block registerMe()
	{
		block.setBlockName(blockID);
		block.setBlockTextureName(MoreBuildingBlocks.MODID + ":" + blockID);
		block.setCreativeTab(Tabs.TAB_MAIN);
		block.setHardness(3F);
		block.setStepSound(soundTypeStone);
		block.setHarvestLevel("pickaxe", 0);
		GameRegistry.registerBlock(block, blockID);
		
		return block;
	}
}
