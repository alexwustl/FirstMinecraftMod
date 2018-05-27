package com.andraken.testmod.items;

import com.andraken.testmod.Main;
import com.andraken.testmod.blocks.BlockGem;
import com.andraken.testmod.init.ModBlocks;
import com.andraken.testmod.init.ModItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemGem extends ItemBase{
	public ItemGem(String name) {
		super(name);
		this.setHasSubtypes(true);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	@Override
	public void registerModels() {
		for(int i=0;i<BlockGem.EnumType.values().length;i++) {
			Main.proxy.registerItemRenderer(ModItems.GEM, i,new ModelResourceLocation(getRegistryName(), "variant=" + BlockGem.EnumType.byMetadata(i).getName()));
		}
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		BlockGem.EnumType variant = BlockGem.EnumType.byMetadata(stack.getMetadata());
		return super.getUnlocalizedName()+"."+BlockGem.EnumType.byMetadata(stack.getMetadata()).getUnlocalizedName();
	}
	@Override
	public void getSubItems(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
    	if (!this.isInCreativeTab(itemIn))
            return;
		for (BlockGem.EnumType blockgem$enumtype : BlockGem.EnumType.values())
		{
			items.add(new ItemStack(this, 1, blockgem$enumtype.getMetadata()));
		}
	}
}
