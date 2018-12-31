package com.psc.mcmod.morebuildingblocks.render;

import org.lwjgl.opengl.GL11;

import com.psc.mcmod.morebuildingblocks.tileentity.TileBall;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

public class RenderBlockBall implements ISimpleBlockRenderingHandler {

	public static int id = RenderingRegistry.getNextAvailableRenderId();
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		TileBall tb = new TileBall();
		tb.blockMetadata = metadata;
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.5F, -0.7F, -0.5F);
		TileEntityRendererDispatcher.instance.renderTileEntityAt(tb, 0.0D, 0.0D, 0.0D, 0.0F);
		GL11.glPopMatrix();
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId,
			RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return id;
	}

}
