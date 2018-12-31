package com.psc.mcmod.morebuildingblocks.items;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.blocks.BlocksInstance;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

public class ItemIronStick extends Item{
	public ItemIronStick() 
	{
		super();
	}
	
	public static final String itemID = "itemIronStick";
	public static final Item item = new ItemIronStick();
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer placer, World world, int x, int y, int z, int a, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(!world.isRemote)
		{
			placer.addChatMessage(new ChatComponentText("Duang~ At X:" + String.valueOf(x) + " Y:" + String.valueOf(y) + " Z:" + String.valueOf(z)));
		}
		world.playSoundAtEntity(placer, "minecraft:random.anvil_land", 0.1F, 1F);
		return false;
	}
	
	public static Item registerMe()
	{
		item.setUnlocalizedName(itemID);
		item.setTextureName(MoreBuildingBlocks.MODID + ":" + itemID);
		item.setCreativeTab(Tabs.TAB_MATERIALS);
		
		GameRegistry.registerItem(item, itemID);
		return item;
	}
}
