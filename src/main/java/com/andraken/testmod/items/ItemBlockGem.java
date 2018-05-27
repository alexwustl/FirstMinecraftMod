package com.andraken.testmod.items;

import com.andraken.testmod.Main;
import com.andraken.testmod.blocks.BlockGem;
import com.andraken.testmod.init.ModItems;
import com.andraken.testmod.util.HasModel;

import net.minecraft.block.Block;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockGem extends ItemBlock{

	public ItemBlockGem(Block block) {
		super(block);
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		this.setRegistryName(block.getRegistryName());
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public int getMetadata(int meta) {
		return meta;
	}
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		BlockGem.EnumType variant = BlockGem.EnumType.byMetadata(stack.getMetadata());
		//return super.getUnlocalizedName(stack).substring(5)+"_"+variant.toString();
		return super.getUnlocalizedName()+"."+BlockGem.EnumType.byMetadata(stack.getMetadata()).getUnlocalizedName();
	}

}
