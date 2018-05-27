package com.andraken.testmod.init;

import java.util.ArrayList;
import java.util.List;

import com.andraken.testmod.blocks.BlockGem;
import com.andraken.testmod.blocks.colors.IBlockGemColor;
import com.andraken.testmod.blocks.ores.BlockOreGem;
import com.andraken.testmod.items.ItemBlockGem;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.SidedProxy;

public class ModBlocks {

	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block GEM_BLOCK = new BlockGem("gem_block");
	public static final Item GEM_BLOCK_ITEM = new ItemBlockGem(GEM_BLOCK);
	public static final Block GEM_BLOCK_ORE = new BlockOreGem("gem_block_ore");
	public static final Item GEM_BLOCK_ORE_ITEM = new ItemBlockGem(GEM_BLOCK_ORE);
}
