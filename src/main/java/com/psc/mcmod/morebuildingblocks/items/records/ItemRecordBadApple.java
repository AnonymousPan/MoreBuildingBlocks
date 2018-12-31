package com.psc.mcmod.morebuildingblocks.items.records;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;
import com.psc.mcmod.morebuildingblocks.gui.creativetabs.Tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ItemRecordBadApple extends ItemRecord {

	protected ItemRecordBadApple() {
		super(MoreBuildingBlocks.MODID + ":" + recordTitle);
	}
	
	public static final String itemID = "itemRecordBadApple";
	public static final String recordTitle = "BadApple";
	public static final String fileName = "BadApple";
	public static final Item item = new ItemRecordBadApple();
	
	public static Item registerMe()
	{
		item.setUnlocalizedName(itemID);
		item.setTextureName(MoreBuildingBlocks.MODID + ":" + itemID);
		item.setCreativeTab(Tabs.TAB_MUSIC);
		
		GameRegistry.registerItem(item, itemID);
		return item;
	}
	
	@Override
	public ResourceLocation getRecordResource(String name) {
		return new ResourceLocation("morebuildingblocks:music." + fileName);
	}

}
