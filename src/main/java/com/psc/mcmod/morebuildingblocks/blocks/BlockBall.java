package com.psc.mcmod.morebuildingblocks.blocks;

import java.util.ArrayList;
import java.util.List;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;
import com.psc.mcmod.morebuildingblocks.items.ItemsInstance;
import com.psc.mcmod.morebuildingblocks.render.RenderBlockBall;
import com.psc.mcmod.morebuildingblocks.render.RenderBlockBiliTV;
import com.psc.mcmod.morebuildingblocks.tileentity.TileBall;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBall extends Block {

	private IIcon iconFace;
	private IIcon iconBack;
	private IIcon iconSide;
	private IIcon iconPFace;
	private IIcon iconPBack;
	private IIcon iconPSide;
	
	public static final String[] field_150096_a = new String[] {"blue", "pink"};

	public BlockBall(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

    @Override
    public int getRenderType() {
        return RenderBlockBall.id;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    @Override
    public boolean hasTileEntity()
    {
    	return true;
    }
    
    @Override
    public boolean hasTileEntity(int metadata)
    {
    	return true;
    }
    
    @Override
    public TileEntity createTileEntity(World world, int metadata) {
		return new TileBall();
	}

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
    	return true;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        for (int i = 0; i < 16; ++i)
        {
            p_149666_3_.add(new ItemStack(p_149666_1_, 1, i));
        }
    }
    
    @Override
    public int damageDropped(int p_149692_1_)
    {
        return p_149692_1_;
    }

    public static int func_150032_b(int p_150032_0_)
    {
        return func_150031_c(p_150032_0_);
    }

    public static int func_150031_c(int p_150031_0_)
    {
        return ~p_150031_0_ & 15;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack)
    {
    	world.setBlock(x, y, z, BlocksInstance.blockBall, stack.getItemDamage(), 3);
    }
    
    public static final String blockID = "blockBall";

	
	public static BlockBall block = new BlockBall(Material.rock);
	
	public static Block registerMe()
	{
		block.setBlockName(blockID);
		block.setCreativeTab(Tabs.TAB_BALLS);
		block.setHardness(0.5F);
		block.setStepSound(soundTypeAnvil);
		GameRegistry.registerBlock(block, blockID);
		
		return block;
	}
}
