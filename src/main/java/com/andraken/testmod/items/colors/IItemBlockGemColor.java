package com.andraken.testmod.items.colors;

import com.andraken.testmod.blocks.BlockGem;
import com.andraken.testmod.init.ModItems;

import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;

public class IItemBlockGemColor implements IItemColor{
	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		return BlockGem.EnumType.values()[stack.getMetadata()].getColor();
	}
	

}
