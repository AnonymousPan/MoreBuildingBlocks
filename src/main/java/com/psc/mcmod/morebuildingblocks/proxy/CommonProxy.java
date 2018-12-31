package com.psc.mcmod.morebuildingblocks.proxy;

import com.psc.mcmod.morebuildingblocks.ItemRegister;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public abstract class CommonProxy {
	public void preInit(FMLPreInitializationEvent event)
    {
		ItemRegister.registerAll();
    }
    
    public void init(FMLInitializationEvent event)
    {
		ItemRegister.addRecipes();
    }
}
