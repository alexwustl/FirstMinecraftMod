package com.andraken.testmod;

import com.andraken.testmod.blocks.colors.IBlockGemColor;
import com.andraken.testmod.init.ModBlocks;
import com.andraken.testmod.init.ModItems;
import com.andraken.testmod.items.colors.IItemBlockGemColor;
import com.andraken.testmod.proxy.CommonProxy;
import com.andraken.testmod.util.Reference;
import com.andraken.testmod.worldgen.GemGen;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name=Reference.NAME,version=Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;
	
	@SidedProxy(modId=Reference.MOD_ID,clientSide=Reference.CLIENT_PROXY_CLASS, serverSide=Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {
		
	}
	
	@EventHandler
	public static void Init(FMLInitializationEvent event) {
		proxy.init();
		/*World Gen*/
		GameRegistry.registerWorldGenerator(new GemGen(), 0);
	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		
	}
}
