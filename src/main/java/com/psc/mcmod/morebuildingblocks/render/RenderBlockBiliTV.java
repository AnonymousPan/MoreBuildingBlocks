package com.psc.mcmod.morebuildingblocks.render;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.world.IBlockAccess;

public class RenderBlockBiliTV implements ISimpleBlockRenderingHandler {
	public static int model = RenderingRegistry.getNextAvailableRenderId();

    @Override
    public void renderInventoryBlock (Block block, int metadata, int modelID, RenderBlocks renderer)
    {
        if (modelID == model)
        {
        	renderer.setRenderBounds(3/32F, 0F, 5/32F, 29/32F, 21/32F, 27/32F);
        	renderStandardInvBlock(renderer, block, metadata);
        	renderer.setRenderBounds(2/32F, 1/32F, 5/32F, 3/32F, 20/32F, 27/32F);          
        	renderStandardInvBlock(renderer, block, metadata);
        	renderer.setRenderBounds(29/32F, 1/32F, 5/32F, 30/32F, 20/32F, 27/32F);
        	renderStandardInvBlock(renderer, block, metadata);
        	renderer.setRenderBounds(11/32F, 21/32F, 15/32F, 13/32F, 26/32F, 17/32F);
        	renderStandardInvBlock(renderer, block, metadata);
            renderer.setRenderBounds(19/32F, 21/32F, 15/32F, 21/32F, 26/32F, 17/32F);
            renderStandardInvBlock(renderer, block, metadata);
        }
    }

    @Override
    public boolean renderWorldBlock (IBlockAccess world, int x, int y, int z, Block block, int modelID, RenderBlocks renderer)

    {
        if (modelID == model)
        {
            int metadata = world.getBlockMetadata(x,y,z);
            metadata %= 2;
            switch(metadata)
            {
            case 0:
            	//Body
                renderer.setRenderBounds(3/32F, 0F, 5/32F, 29/32F, 21/32F, 27/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Left side
                renderer.setRenderBounds(2/32F, 1/32F, 5/32F, 3/32F, 20/32F, 27/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Right side
                renderer.setRenderBounds(29/32F, 1/32F, 5/32F, 30/32F, 20/32F, 27/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Left Antenna
                renderer.setRenderBounds(11/32F, 21/32F, 15/32F, 13/32F, 28/32F, 17/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Right Antenna
                renderer.setRenderBounds(19/32F, 21/32F, 15/32F, 21/32F, 28/32F, 17/32F);
                renderer.renderStandardBlock(block, x, y, z);
            	break;
            case 1:
            	//Body
                renderer.setRenderBounds(5/32F, 0F, 3/32F, 27/32F, 21/32F, 29/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Left side
                renderer.setRenderBounds(5/32F, 1/32F, 2/32F, 27/32F, 20/32F, 3/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Right side
                renderer.setRenderBounds(5/32F, 1/32F, 29/32F, 27/32F, 20/32F, 30/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Left Antenna
                renderer.setRenderBounds(15/32F, 21/32F, 11/32F, 17/32F, 28/32F, 13/32F);
                renderer.renderStandardBlock(block, x, y, z);
                //Right Antenna
                renderer.setRenderBounds(15/32F, 21/32F, 19/32F, 17/32F, 28/32F, 21/32F);
                renderer.renderStandardBlock(block, x, y, z);
                break;
            }  
            return true;
        }
        return false;
    }

    @Override
    public boolean shouldRender3DInInventory (int modelID)
    {
        if(modelID == this.model) 
        {
        	return true;
        }
		return true;
    }

    @Override
    public int getRenderId ()
    {
        return model;
    }

    public static void renderStandardInvBlock (RenderBlocks renderblocks, Block block, int meta)
    {
        //System.out.println("RENDERING BLOCK_BILI_TV");
        Tessellator tessellator = Tessellator.instance;
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderblocks.renderFaceYNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(0, meta));
        //System.out.println(block.getUnlocalizedName());
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderblocks.renderFaceYPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(1, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderblocks.renderFaceZNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(2, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderblocks.renderFaceZPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(3, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderblocks.renderFaceXNeg(block, 0.0D, 0.0D, 0.0D, block.getIcon(4, meta));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderblocks.renderFaceXPos(block, 0.0D, 0.0D, 0.0D, block.getIcon(5, meta));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
    }
}
