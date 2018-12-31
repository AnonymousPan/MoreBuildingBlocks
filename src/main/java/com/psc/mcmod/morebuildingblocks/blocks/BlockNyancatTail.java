package com.psc.mcmod.morebuildingblocks.blocks;

import java.util.ArrayList;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;
import com.psc.mcmod.morebuildingblocks.items.ItemsInstance;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class BlockNyancatTail extends Block {
	public BlockNyancatTail(Material material)
	{
		 super(material);
	}
	
	public static final String blockID = "blockNyancatTail";
	
	public static BlockNyancatTail block = new BlockNyancatTail(Material.rock);
	
	public static Block registerMe()
	{
		
		block.setBlockName(blockID);
		block.setBlockTextureName(MoreBuildingBlocks.MODID + ":" + blockID);
		block.setCreativeTab(Tabs.TAB_MAIN);
		block.setHardness(1F);
		block.setStepSound(soundTypeStone);
		block.setHarvestLevel("pickaxe", 2);
		GameRegistry.registerBlock(block, blockID);
		
		return block;
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase player, ItemStack stack)
	{
		if (!world.getBlock(x, y, z).getMaterial().isSolid())
        {
            return;
        }
        else
        {
            if (world.isRemote)
            {
                return;
            }
            else
            {
            	float yaw = Math.abs(player.rotationYaw);
            	float pitch = player.rotationPitch;
            	yaw %= 360F;
            	int metadata = 0;
            	if(pitch <= -60)                                      metadata = 5;
            	if(pitch >= 60)                                       metadata = 4;
            	else if((yaw >= 315F) || ((yaw < 45F) && yaw >= 0F))  metadata = 2;
            	else if((yaw >= 45F) && (yaw < 135F))                 metadata = 1;
            	else if((yaw >= 135F) && (yaw < 225F))                metadata = 0;
            	else if((yaw >= 225F) && (yaw < 315F))                metadata = 3;
            	
            	world.setBlock(x, y, z, BlocksInstance.blockNyancatTail, metadata, 3);

                --stack.stackSize;
                return;
            }
        }
	}
	
	IIcon side;
	IIcon side1;
	IIcon bottom;
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
    	this.side   = p_149651_1_.registerIcon("morebuildingblocks:blockNyancatTail_side");
    	this.side1  = p_149651_1_.registerIcon("morebuildingblocks:blockNyancatTail_side1");
    	this.bottom = p_149651_1_.registerIcon("morebuildingblocks:blockNyancatTail_bottom");
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int face, int number)
    {
    	if((number == 0) || (number == 2))
    	{
    		if((face == 4) || (face == 5)) return bottom;
    		else return side;
    	}
    	else if((number == 1) || (number == 3))
    	{
    		if((face == 2) || (face == 3)) return bottom;
    		else return side;
    	}
    	else if((number == 4) || (number == 5))
    	{
    		if((face == 0) || (face == 1)) return bottom;
    		else return side1;
    	}
    	return side;
    }
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
    {
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(new ItemStack(BlocksInstance.blockNyancatTail));
        return ret;
    }
}
