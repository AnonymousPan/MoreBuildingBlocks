package com.psc.mcmod.morebuildingblocks.tileentity;

import net.minecraft.tileentity.TileEntity;

public class TileBall extends TileEntity {
	public static final String id = "ball";
	
	@Override
	public void updateEntity()
	{
		this.blockMetadata = this.getBlockMetadata();
	}
}
