package com.psc.mcmod.morebuildingblocks.blocks;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.GameRegistry.ObjectHolder;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.*;

public class BlockFacingTest extends Block {
	private IIcon icon2;
	private IIcon icon1;
	private IIcon icon3;
	private IIcon icon0;
	private IIcon icon4;
	private IIcon icon5;

	public BlockFacingTest(Material material)
	{
		 super(material);
	}
	
	public static final String blockID = "blockFacingTest";
	
	public static BlockFacingTest block = new BlockFacingTest(Material.rock);
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int number, int face)
    {
    	switch(number)
    	{
    	case 0:
    		return icon0;
		case 1:
    		return icon1;
		case 2:
    		return icon2;
		case 3:
    		return icon3;
		case 4:
    		return icon4;
		default:
    		return icon5;
    	}
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    this.icon1 = p_149651_1_.registerIcon("morebuildingblocks:blockFacingTest_1");
    this.icon2 = p_149651_1_.registerIcon("morebuildingblocks:blockFacingTest_2");
    this.icon3 = p_149651_1_.registerIcon("morebuildingblocks:blockFacingTest_3");
    this.icon0 = p_149651_1_.registerIcon("morebuildingblocks:blockFacingTest_0");
    this.icon4 = p_149651_1_.registerIcon("morebuildingblocks:blockFacingTest_4");
    this.icon5 = p_149651_1_.registerIcon("morebuildingblocks:blockFacingTest_5");
    }
	
	public static Block registerMe()
	{
		
		block.setBlockName(blockID);
		block.setBlockTextureName(MoreBuildingBlocks.MODID + ":" + blockID);
		block.setCreativeTab(Tabs.TAB_TOOLS);
		block.setHardness(3F);
		block.setStepSound(soundTypeStone);
		block.setHarvestLevel("pickaxe", 0);
		GameRegistry.registerBlock(block, blockID);
		
		return block;
	}
}
