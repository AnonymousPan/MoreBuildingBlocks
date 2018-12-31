package com.psc.mcmod.morebuildingblocks.blocks;

import java.util.ArrayList;
import java.util.List;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.items.ItemsInstance;
import com.psc.mcmod.morebuildingblocks.render.RenderBlockBiliTV;

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

public class BlockBiliTV extends Block {

	private IIcon iconFace;
	private IIcon iconBack;
	private IIcon iconSide;
	private IIcon iconPFace;
	private IIcon iconPBack;
	private IIcon iconPSide;
	
	public static final String[] field_150096_a = new String[] {"blue", "pink"};

	public BlockBiliTV(Material p_i45394_1_) {
		super(p_i45394_1_);
		// TODO Auto-generated constructor stub
	}

    @Override
    public int getRenderType() {
    	//System.out.println("getRenderType has been called.");
        return RenderBlockBiliTV.model;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
    
    public String getTextureDomain(int textureNameIndex)
    {
        return "morebuildingblocks";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_)
    {
    	return true;
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        Block b = world.getBlock(x, y, z);
        int metadata = world.getBlockMetadata(x, y, z);
        if(metadata < 4)
        {
        	if(metadata == 3)
        	{
        		metadata = 0;
        	}
        	else metadata++;	
        }
        else
        {
        	if(metadata == 7)
        	{
        		metadata = 4;
        	}
        	else metadata++;	
        }
        world.setBlock(x, y, z, b, metadata, 2 | 4);
        return false;
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase placer, ItemStack stack) 
    {
    	//System.out.println("YAW=" + String.valueOf(placer.rotationYaw + " PITCH=" + String.valueOf(placer.rotationPitch)));
    	float yaw = Math.abs(placer.rotationYaw);
    	yaw %= 360F;
    	int metadata = 0;
    	if((yaw >= 315F) || ((yaw < 45F) && yaw >= 0F))
    	{
    		metadata = 2;
    	}
    	else if((yaw >= 45F) && (yaw < 135F))
    	{
    		metadata = 1;
    	}
    	else if((yaw >= 135F) && (yaw < 225F))
    	{
    		metadata = 0;
    	}
    	else if((yaw >= 225F) && (yaw < 315F))
    	{
    		metadata = 3;
    	}
    	
    	if(stack.getItemDamage() == 4)
    	{
    		metadata += 4;
    	}
    	
    	Block b = world.getBlock(x, y, z);
    	world.setBlock(x, y, z, b, metadata, 2 | 4);
    	//System.out.println(String.valueOf(stack.getItemDamage())); 	
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int number, int face)
    {
    	switch(face)
    	{
    		case 0:
    			switch(number)
    			{
    			case 3: return iconFace;
    			case 2: return iconBack;
   				default: return iconSide;
    			}
    		case 1:
    			switch(number)
    	    	{
    	    	case 4: return iconFace;
    			case 5: return iconBack;
    			default: return iconSide;
    	    	}
    		case 2:
    			switch(number)
    			{
    			case 2: return iconFace;
    			case 3: return iconBack;
   				default: return iconSide;
    			}
    		case 3:
    			switch(number)
    	    	{
    	    	case 5: return iconFace;
    			case 4: return iconBack;
    			default: return iconSide;
    	    	}
    		case 4:
    			switch(number)
    			{
    			case 3: return iconPFace;
    			case 2: return iconPBack;
   				default: return iconPSide;
    			}
    		case 5:
    			switch(number)
    	    	{
    	    	case 4: return iconPFace;
    			case 5: return iconPBack;
    			default: return iconPSide;
    	    	}
    		case 6:
    			switch(number)
    			{
    			case 2: return iconPFace;
    			case 3: return iconPBack;
   				default: return iconPSide;
    			}
    		case 7:
    			switch(number)
    	    	{
    	    	case 5: return iconPFace;
    			case 4: return iconPBack;
    			default: return iconPSide;
    	    	}
    		default:
    			return null;
    	}
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    	this.iconFace = p_149651_1_.registerIcon("morebuildingblocks:blockBiliTV_front");
    	this.iconBack = p_149651_1_.registerIcon("morebuildingblocks:blockBiliTV_back");
    	this.iconSide = p_149651_1_.registerIcon("morebuildingblocks:blockBiliTV_side");
    	this.iconPFace = p_149651_1_.registerIcon("morebuildingblocks:blockBiliTV_pink_front");
    	this.iconPBack = p_149651_1_.registerIcon("morebuildingblocks:blockBiliTV_pink_back");
    	this.iconPSide = p_149651_1_.registerIcon("morebuildingblocks:blockBiliTV_pink_side");
    }
    
public static final String blockID = "blockBiliTV";
/*
	@Override
	public int onBlockPlaced(World world, int x, int y, int z, int a, float b, float c, float d, int e)
	{
		System.out.println("x/y/z=" + String.valueOf(x) +"/" + String.valueOf(y) + "/" + String.valueOf(z));
		System.out.println("a=" + String.valueOf(a) +" b=" + String.valueOf(b) + " c=" + String.valueOf(c)+ " d=" + String.valueOf(d)+ " e=" + String.valueOf(e));
		return 0;
	}
	*/
	
	public static BlockBiliTV block = new BlockBiliTV(Material.rock);
	
	@SideOnly(Side.CLIENT)
    public void getSubBlocks(Block p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(BlocksInstance.blockBiliTV, 1, 0));
        p_149666_3_.add(new ItemStack(BlocksInstance.blockBiliTV, 1, 4));
    }
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

        if(metadata > 3)
        {
        	ret.add(new ItemStack(ItemsInstance.itemBlockBiliTVPink,1,0));
        	return ret;
        }
        else
        {
        	ret.add(new ItemStack(ItemsInstance.itemBlockBiliTV,1,0));
        	return ret;
        }
    }
	
	public static Block registerMe()
	{
		block.setBlockName(blockID);
		//block.setCreativeTab(CreativeTabs.tabDecorations);
		block.setHardness(0.75F);
		block.setStepSound(soundTypeAnvil);
		block.setHarvestLevel("", -1);
		GameRegistry.registerBlock(block, blockID);
		
		return block;
	}
}
