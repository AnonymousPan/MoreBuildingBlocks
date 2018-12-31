package com.psc.mcmod.morebuildingblocks;

import net.minecraft.init.Blocks;

import com.psc.mcmod.morebuildingblocks.blocks.*;
import com.psc.mcmod.morebuildingblocks.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.relauncher.Side;

@Mod(modid = MoreBuildingBlocks.MODID, version = MoreBuildingBlocks.VERSION)
public class MoreBuildingBlocks
{
    public static final String MODID = "morebuildingblocks";
    public static final String VERSION = "1.0";
    
    @SidedProxy(clientSide = "com.psc.mcmod.morebuildingblocks.proxy.ClientProxy", serverSide = "com.psc.mcmod.morebuildingblocks.proxy.ServerProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
		proxy.preInit(event);
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		proxy.init(event);
    }
}
