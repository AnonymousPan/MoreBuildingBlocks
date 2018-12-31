package com.psc.mcmod.morebuildingblocks.render;

import org.lwjgl.opengl.GL11;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RenderTileBall extends TileEntitySpecialRenderer {

	ModelBall model = new ModelBall();
	
	@Override
	public void renderTileEntityAt(TileEntity te, double posX, double posY, double posZ,
			float p_147500_8_) {
		// TODO Auto-generated method stub
		String filename;
		int metadata = te.getBlockMetadata();
		if(metadata > 9)
		{
			switch(metadata)
			{
			case 10: filename = "a"; break;
			case 11: filename = "b"; break;
			case 12: filename = "c"; break;
			case 13: filename = "d"; break;
			case 14: filename = "e"; break;
			case 15: filename = "f"; break;
			default: filename = "error_metadata"; break;
			}
		}
		else
		{
			filename = String.valueOf(te.getBlockMetadata());
		}
		bindTexture(new ResourceLocation(MoreBuildingBlocks.MODID + ":textures/pure_color/" + filename + ".png"));
		GL11.glPushMatrix();
		GL11.glTranslated(posX + 0.5, posY + 0.5, posZ + 0.5);
		GL11.glScalef(1F, 1F, 1F);
		
		GL11.glPushMatrix();
		GL11.glRotatef(0.5F, 0F, 1F, 0.5F);
		model.render();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

}
