package com.psc.mcmod.morebuildingblocks.items;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.blocks.BlocksInstance;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlockBiliTVPink extends Item {

	public ItemBlockBiliTVPink() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static Item item = new ItemBlockBiliTVPink();
	public static final String itemID = "itemBlockBiliTVPink";
	
	@Override
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        if (p_77648_7_ == 0)
        {
            return false;
        }
        else if (!p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_).getMaterial().isSolid())
        {
            return false;
        }
        else
        {
            if (p_77648_7_ == 1)
            {
                ++p_77648_5_;
            }

            if (p_77648_7_ == 2)
            {
                --p_77648_6_;
            }

            if (p_77648_7_ == 3)
            {
                ++p_77648_6_;
            }

            if (p_77648_7_ == 4)
            {
                --p_77648_4_;
            }

            if (p_77648_7_ == 5)
            {
                ++p_77648_4_;
            }

            if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
            {
                return false;
            }
            else if (p_77648_3_.isRemote)
            {
                return true;
            }
            else
            {
            	float yaw = Math.abs(p_77648_2_.rotationYaw);
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
            	metadata += 4;
            	p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, BlocksInstance.blockBiliTV, metadata, 3);
            	
            	
                --p_77648_1_.stackSize;
                return true;
            }
        }
    }
	
	public static Item registerMe()
	{
		item.setCreativeTab(Tabs.TAB_MAIN);
		item.setTextureName(MoreBuildingBlocks.MODID + ":"  + itemID);
		item.setUnlocalizedName(itemID);
		
		GameRegistry.registerItem(item, itemID);
		return item;
	}
}
