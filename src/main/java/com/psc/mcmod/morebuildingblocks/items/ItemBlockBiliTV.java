package com.psc.mcmod.morebuildingblocks.items;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.blocks.BlocksInstance;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemBlockBiliTV extends Item{
	public ItemBlockBiliTV() 
	{
		super();
	}
	
	public static final String itemID = "itemBlockBiliTV";
	public static final Item item = new ItemBlockBiliTV();
	
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (!world.getBlock(x, y, z).getMaterial().isSolid())
        {
            return false;
        }
        else
        {
            if (side == 1)
            {
                ++y;
            }

            if (side == 2)
            {
                --z;
            }

            if (side == 3)
            {
                ++z;
            }

            if (side == 4)
            {
                --x;
            }

            if (side == 5)
            {
                ++x;
            }

            if (!player.canPlayerEdit(x, y, z, side, stack))
            {
                return false;
            }
            else if (world.isRemote)
            {
                return true;
            }
            else
            {
            	float yaw = Math.abs(player.rotationYaw);
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
            	
            	world.setBlock(x, y, z, BlocksInstance.blockBiliTV, metadata, 3);

                --stack.stackSize;
                return true;
            }
        }
    }
	
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player)
    {
        if(world.getBlockMetadata(x, y, z) > 3)
        {
        	return new ItemStack(ItemsInstance.itemBlockBiliTV);
        }
        else
        {
        	return new ItemStack(ItemsInstance.itemBlockBiliTVPink);
        }
    }
	
	public static Item registerMe()
	{
		item.setUnlocalizedName(itemID);
		item.setTextureName(MoreBuildingBlocks.MODID + ":" + itemID);
		item.setCreativeTab(Tabs.TAB_MAIN);
		
		GameRegistry.registerItem(item, itemID);
		return item;
	}
}
