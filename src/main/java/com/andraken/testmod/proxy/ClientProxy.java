package com.andraken.testmod.proxy;

import com.andraken.testmod.blocks.colors.IBlockGemColor;
import com.andraken.testmod.init.ModBlocks;
import com.andraken.testmod.init.ModItems;
import com.andraken.testmod.items.colors.IItemBlockGemColor;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy{
	
	@Override
	public void registerItemRenderer(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	@Override
	public void registerItemRenderer(Item item, int meta, ModelResourceLocation loc) {
		ModelLoader.setCustomModelResourceLocation(item, meta, loc);
	}
	public void registerItemColorRenderer(IItemColor color,Item item) {
		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(color, item);
	}
	public void registerBlockColorRenderer(IBlockColor color,Block block) {
		Minecraft.getMinecraft().getBlockColors().registerBlockColorHandler(color, block);
	}
	@Override
	public void init() {
		this.registerItemColorRenderer(new IItemBlockGemColor(), ModBlocks.GEM_BLOCK_ITEM);
		this.registerBlockColorRenderer(new IBlockGemColor(), ModBlocks.GEM_BLOCK);
		this.registerItemColorRenderer(new IItemBlockGemColor(), ModBlocks.GEM_BLOCK_ORE_ITEM);
		this.registerBlockColorRenderer(new IBlockGemColor(), ModBlocks.GEM_BLOCK_ORE);
		this.registerItemColorRenderer(new IItemBlockGemColor(), ModItems.GEM);
	}
}
