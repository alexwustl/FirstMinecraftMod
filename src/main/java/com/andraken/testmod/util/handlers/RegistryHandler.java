package com.andraken.testmod.util.handlers;

import com.andraken.testmod.init.ModBlocks;
import com.andraken.testmod.init.ModItems;
import com.andraken.testmod.util.HasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		Item[] temp =ModItems.ITEMS.toArray(new Item[0]);
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item :ModItems.ITEMS) {
			if(item instanceof HasModel) {
				((HasModel) item).registerModels();
			}
		}
		for(Block block :ModBlocks.BLOCKS) {
			if(block instanceof HasModel) {
				((HasModel) block).registerModels();
			}
		}
	}	
}
