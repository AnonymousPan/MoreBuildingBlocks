package com.psc.mcmod.morebuildingblocks.proxy;

import com.psc.mcmod.morebuildingblocks.ItemRegister;
import com.psc.mcmod.morebuildingblocks.render.RenderTileBall;
import com.psc.mcmod.morebuildingblocks.tileentity.TileBall;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent event)
    {
		super.preInit(event);
    }
    
    public void init(FMLInitializationEvent event)
    {
		super.init(event);
		
		ItemRegister.registerModel();
    }
}
