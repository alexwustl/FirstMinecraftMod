package com.andraken.testmod.worldgen;

import java.util.Collection;
import java.util.Random;

import com.andraken.testmod.blocks.BlockGem;
import com.andraken.testmod.init.ModBlocks;
import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

/* Cite https://www.suppergerrie2.com/minecraft-1-12-modding-with-forge-7-custom-ore-generation/*/
public class GemGen implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.getDimension()) {
		//Nether
		case -1:
		  break;
		//Overworld
		case 0:
			Collection values = BlockGem.VARIANT.getAllowedValues();
		  for(int meta=0;meta<values.size();meta++) {
			  runGenerator(ModBlocks.GEM_BLOCK_ORE.getDefaultState().withProperty(BlockGem.VARIANT, BlockGem.EnumType.byMetadata(meta)),7,10,30,50,BlockMatcher.forBlock(Blocks.STONE),world,random,chunkX,chunkZ);
		  }
		//End
		case 1:
		  break;
		//Everything else
		default:
		  break;
		}
		
	}

	private void runGenerator(IBlockState blockToGen, int blockAmount,  int chancesToSpawn, int minHeight, int maxHeight, Predicate<IBlockState> blockToReplace, World world, Random rand, int chunk_X, int chunk_Z){

		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		WorldGenMinable generator = new WorldGenMinable(blockToGen, blockAmount, blockToReplace);
		int heightdiff = maxHeight - minHeight +1;
		for (int i=0; i<chancesToSpawn; i++){
			int x = chunk_X * 16 +rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightdiff);
			int z = chunk_Z * 16 + rand.nextInt(16);

			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
}
