package com.andraken.testmod.proxy;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class CommonProxy {

	public void registerItemRenderer(Item item) {};
	public void registerItemRenderer(Item gemBlockItem, int i, ModelResourceLocation modelResourceLocation) {};
	public void init() {};
}
