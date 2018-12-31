package com.psc.mcmod.morebuildingblocks.render;

import com.psc.mcmod.morebuildingblocks.MoreBuildingBlocks;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class ModelBall {
	private IModelCustom model;
	public ModelBall()
	{
		model = AdvancedModelLoader.loadModel(new ResourceLocation(MoreBuildingBlocks.MODID + ":model/ball.obj"));
	}
	
	public void render()
	{
		model.renderAll();
	}
}
