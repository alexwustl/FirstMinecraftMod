package com.andraken.testmod.blocks;

import com.andraken.testmod.Main;
import com.andraken.testmod.init.ModBlocks;
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
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGem extends BlockBase{

	/**
	 * This describes a basic gem block that can take on six different colors. Heavily influenced by the BlockPlanks class from minecraft. The goal of this class is to learn more about metadata.
	 */
	public static final PropertyEnum<BlockGem.EnumType> VARIANT = PropertyEnum.<BlockGem.EnumType>create("variant", BlockGem.EnumType.class);
	
	public BlockGem(String name) {
		super(name, Material.IRON,CreativeTab.modTab);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockGem.EnumType.BLUE));
		
		setSoundType(SoundType.STONE)
		.setHardness(3.0F)
		.setResistance(20.0F)
		.setLightLevel(0.5F)
		.setLightOpacity(0);
		setHarvestLevel("pickaxe",2);
	}
	

	@Override
	public void registerModels() {
		for(int i=0;i<BlockGem.EnumType.values().length;i++) {
			Main.proxy.registerItemRenderer(ModBlocks.GEM_BLOCK_ITEM, i,new ModelResourceLocation(getRegistryName(), "variant=" + BlockGem.EnumType.byMetadata(i).getName()));
		}
	}
    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
	@Override
    public int damageDropped(IBlockState state)
    {
        return ((BlockGem.EnumType)state.getValue(VARIANT)).getMetadata();
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
    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockGem.EnumType.byMetadata(meta));
    }

    /**
     * Get the MapColor for this Block and the given BlockState
     */
    @Override
    public MapColor getMapColor(IBlockState state, IBlockAccess worldIn, BlockPos pos)
    {
        return ((BlockGem.EnumType)state.getValue(VARIANT)).getMapColor();
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockGem.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {VARIANT});
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	public static enum EnumType implements IStringSerializable
    {
        RED(0, "red", MapColor.RED,0x00FF0000),
        BLUE(1, "blue", MapColor.BLUE,0x000000FF),
        GREEN(2, "green", MapColor.GREEN,0x0000FF00),
        YELLOW(3, "yellow", MapColor.YELLOW,0x00FFFF00),
        BLACK(4, "black", MapColor.BLACK,0x00555555),
        WHITE(5, "white", MapColor.WHITE_STAINED_HARDENED_CLAY,0x00AAAAAA);

        private static final BlockGem.EnumType[] META_LOOKUP = new BlockGem.EnumType[values().length];
        private final int meta;
        private final String name;
        private final String unlocalizedName;
        /** The color that represents this entry on a map. */
        private final MapColor mapColor;
        private final int color;
        private EnumType(int metaIn, String nameIn, MapColor mapColorIn,int color)
        {
            this(metaIn, nameIn, nameIn, mapColorIn,color);
        }

        private EnumType(int metaIn, String nameIn, String unlocalizedNameIn, MapColor mapColorIn,int color)
        {
            this.meta = metaIn;
            this.name = nameIn;
            this.unlocalizedName = unlocalizedNameIn;
            this.mapColor = mapColorIn;
            this.color = color;
        }
        
        public int getMetadata()
        {
            return this.meta;
        }

        /**
         * The color which represents this entry on a map.
         */
        public MapColor getMapColor()
        {
            return this.mapColor;
        }
        
        public int getColor() {
        	return this.color;
        }
        public String toString()
        {
            return this.name;
        }

        public static BlockGem.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }
        
        public String getName()
        {
            return this.name;
        }

        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }

        static
        {
            for (BlockGem.EnumType blockgem$enumtype : values())
            {
                META_LOOKUP[blockgem$enumtype.getMetadata()] = blockgem$enumtype;
            }
        }
    }
}
