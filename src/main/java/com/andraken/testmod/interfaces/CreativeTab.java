package com.andraken.testmod.interfaces;

import com.andraken.testmod.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTab extends CreativeTabs {

	
	public static final CreativeTab modTab = new CreativeTab("item_tab_first_mod");

	public CreativeTab(String label) {
		super(label);
		this.setBackgroundImageName("item_search.png");
		System.out.println("Loading tab");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.GEM_BLOCK_ITEM);
	}
	@Override
	public boolean hasSearchBar() {
		return true;
	}

}
