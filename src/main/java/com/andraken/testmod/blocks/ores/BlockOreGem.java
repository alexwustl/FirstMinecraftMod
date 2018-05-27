package com.andraken.testmod.blocks.ores;

import java.util.Random;

import com.andraken.testmod.Main;
import com.andraken.testmod.blocks.BlockBase;
import com.andraken.testmod.blocks.BlockGem;
import com.andraken.testmod.init.ModBlocks;
import com.andraken.testmod.init.ModItems;
import com.andraken.testmod.interfaces.CreativeTab;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOreGem extends BlockBase{
	
	public BlockOreGem(String name) {
		super(name, Material.IRON,CreativeTab.modTab);

		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockGem.VARIANT, BlockGem.EnumType.BLUE));

		setSoundType(SoundType.STONE)
		.setHardness(3.0F)
		.setResistance(20.0F)
		.setLightOpacity(0);
		setHarvestLevel("pickaxe",2);
	}


	@Override
	public void registerModels() {
		for(int i=0;i<BlockGem.EnumType.values().length;i++) {
			Main.proxy.registerItemRenderer(ModBlocks.GEM_BLOCK_ORE_ITEM, i,new ModelResourceLocation(getRegistryName(), "variant=" + BlockGem.EnumType.byMetadata(i).getName()));
		}
	}
	/**
	 * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
	 * returns the metadata of the dropped item based on the old metadata of the block.
	 */

	public int damageDropped(IBlockState state)
	{
		return ((BlockGem.EnumType)state.getValue(BlockGem.VARIANT)).getMetadata();
	}

	/**
	 * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
	 */
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		for (BlockGem.EnumType blockgem$enumtype : BlockGem.EnumType.values())
		{
			items.add(new ItemStack(this, 1, blockgem$enumtype.getMetadata()));
		}
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(BlockGem.VARIANT, BlockGem.EnumType.byMetadata(meta));
	}

	/**
	 * Get the MapColor for this Block and the given BlockState
	 */
	public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
	{
		return ((BlockGem.EnumType)state.getValue(BlockGem.VARIANT)).getMapColor();
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockGem.EnumType)state.getValue(BlockGem.VARIANT)).getMetadata();
	}

	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {BlockGem.VARIANT});
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return ModItems.GEM;
	}
	@Override
	public int quantityDropped(Random random)
	{
		return  2 + random.nextInt(2);
	}
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		if (fortune > 0 && ModBlocks.GEM_BLOCK_ORE_ITEM != this.getItemDropped(this.getDefaultState(), random, fortune))
		{
			int i = random.nextInt(fortune + 2) - 1;

			if (i < 0)
			{
				i = 0;
			}

			return this.quantityDropped(random) + (i);
		}
		else
		{
			return this.quantityDropped(random);
		}
	}
	@Override
	public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
	{
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		return MathHelper.getInt(rand, 0, 2);
	}

}
