package com.andraken.testmod.items;

import com.andraken.testmod.Main;
import com.andraken.testmod.init.ModItems;
import com.andraken.testmod.interfaces.CreativeTab;
import com.andraken.testmod.util.HasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements HasModel{

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTab.modTab);
		ModItems.ITEMS.add(this);
	}
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this);
	}
	
	

	
}
