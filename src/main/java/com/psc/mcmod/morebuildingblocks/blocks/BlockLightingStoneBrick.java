package com.psc.mcmod.morebuildingblocks.blocks;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.*;

public class BlockLightingStoneBrick extends Block {
	public BlockLightingStoneBrick(Material material)
	{
		 super(material);
	}
	
	public static final String blockID = "blockLightingStoneBrick";
	
	public static BlockLightingStoneBrick block = new BlockLightingStoneBrick(Material.rock);
	
	public static Block registerMe()
	{
		block.setBlockName(blockID);
		block.setBlockTextureName(MoreBuildingBlocks.MODID + ":" + blockID);
		block.setCreativeTab(Tabs.TAB_MAIN);
		block.setHardness(3F);
		block.setStepSound(soundTypeStone);
		block.setHarvestLevel("pickaxe", 0);
		block.setLightLevel(15/16F);
		GameRegistry.registerBlock(block, blockID);
		
		return block;
	}
}
