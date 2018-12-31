package com.psc.mcmod.morebuildingblocks;

import com.psc.mcmod.morebuildingblocks.blocks.*;
import com.psc.mcmod.morebuildingblocks.items.*;
import com.psc.mcmod.morebuildingblocks.items.records.ItemRecordDejavu;
import com.psc.mcmod.morebuildingblocks.items.records.ItemRecordBadApple;
import com.psc.mcmod.morebuildingblocks.items.records.ItemRecordSenbonZakura;
import com.psc.mcmod.morebuildingblocks.render.RenderBlockBall;
import com.psc.mcmod.morebuildingblocks.render.RenderBlockBiliTV;
import com.psc.mcmod.morebuildingblocks.render.RenderTileBall;
import com.psc.mcmod.morebuildingblocks.tileentity.TileBall;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.*;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ItemRegister {
	
	public static void registerAll()
	{
		//Blocks		
		BlocksInstance.blockCreeper = BlockCreeper.registerMe();
		BlocksInstance.blockSmallStoneBrick = BlockSmallStoneBrick.registerMe();
		BlocksInstance.blockLightingStoneBrick = BlockLightingStoneBrick.registerMe();
		BlocksInstance.blockLightingSmallStoneBrick = BlockLightingSmallStoneBrick.registerMe();
		BlocksInstance.blockBiliTV = BlockBiliTV.registerMe();
		BlocksInstance.blockFacingTest = BlockFacingTest.registerMe();
		BlocksInstance.blockNyancatTail = BlockNyancatTail.registerMe();
		BlocksInstance.blockBall = BlockBall.registerMe();
		
		//Items
		ItemsInstance.itemIronStick = ItemIronStick.registerMe();
		
		//Records
		ItemsInstance.itemRecordSenbonZakura = ItemRecordSenbonZakura.registerMe();
		ItemsInstance.itemRecordBadApple = ItemRecordBadApple.registerMe();
		ItemsInstance.itemRecordDejavu = ItemRecordDejavu.registerMe();
		
		//ItemBlocks
		ItemsInstance.itemBlockBiliTV = ItemBlockBiliTV.registerMe();
		ItemsInstance.itemBlockBiliTVPink = ItemBlockBiliTVPink.registerMe();
		
		//TileEntities
		GameRegistry.registerTileEntity(TileBall.class, TileBall.id);
	}
	
	public static void addRecipes()
	{
		//Blocks
		GameRegistry.addShapedRecipe(new ItemStack(BlocksInstance.blockCreeper), new Object[] {"%#%","#@#","%#%",'#',Items.gunpowder,'%',Items.rotten_flesh,'@',Blocks.diamond_block});
		GameRegistry.addShapedRecipe(new ItemStack(BlocksInstance.blockCreeper), new Object[] {"#%#","%@%","#%#",'#',Items.gunpowder,'%',Items.rotten_flesh,'@',Blocks.diamond_block});
		GameRegistry.addShapedRecipe(new ItemStack(BlocksInstance.blockFacingTest),new Object[] {"#@#","@%@","#@#",'@',Blocks.wool,'#',Items.sign,'%',Items.compass});
		GameRegistry.addShapedRecipe(new ItemStack(BlocksInstance.blockFacingTest),new Object[] {"@#@","#%#","@#@",'@',Blocks.wool,'#',Items.sign,'%',Items.compass});
		GameRegistry.addShapedRecipe(new ItemStack(BlocksInstance.blockLightingSmallStoneBrick,8,0), new Object[] {"###","#@#","###",'#',BlocksInstance.blockSmallStoneBrick,'@',Blocks.glowstone});
		GameRegistry.addShapedRecipe(new ItemStack(BlocksInstance.blockSmallStoneBrick,4,0), new Object[] {"##","##",'#',new ItemStack(Blocks.stonebrick,1,0),});
		GameRegistry.addShapedRecipe(new ItemStack(BlocksInstance.blockLightingStoneBrick,8,0), new Object[] {"###","#@#","###",'#',new ItemStack(Blocks.stonebrick,1,0),'@',Blocks.glowstone});
		
		//Items
		GameRegistry.addShapedRecipe(new ItemStack(ItemsInstance.itemIronStick,4,0), new Object[] {"#","#",'#',Items.iron_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ItemsInstance.itemBlockBiliTV), new Object[] {"121","343","353",'1',ItemsInstance.itemIronStick,'2',new ItemStack(Items.dye,1,12),'3',Items.iron_ingot,'4',Blocks.quartz_block,'5',Blocks.redstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(ItemsInstance.itemBlockBiliTVPink), new Object[] {"121","343","353",'1',ItemsInstance.itemIronStick,'2',new ItemStack(Items.dye,1,13),'3',Items.iron_ingot,'4',Blocks.quartz_block,'5',Blocks.redstone_block});
	}
	
	public static void registerModel()
	{
		RenderBlockBiliTV biliTVRender = new RenderBlockBiliTV();
		RenderingRegistry.registerBlockHandler(biliTVRender.model, biliTVRender);
		RenderBlockBall ballRender = new RenderBlockBall();
		RenderingRegistry.registerBlockHandler(ballRender.id,ballRender);
		ClientRegistry.bindTileEntitySpecialRenderer(TileBall.class, new RenderTileBall());
	}
}
