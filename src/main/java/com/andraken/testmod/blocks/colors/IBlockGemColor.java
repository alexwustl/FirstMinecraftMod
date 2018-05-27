package com.andraken.testmod.blocks.colors;

import com.andraken.testmod.blocks.BlockGem;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class IBlockGemColor implements IBlockColor{
	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn, BlockPos pos, int tintIndex) {
		if (tintIndex == 0) {
			return ((BlockGem.EnumType)state.getValue(BlockGem.VARIANT)).getColor();
		} else {
			return 0xffffff;
		}
	}

}
