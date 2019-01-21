package com.nuvemplugins.lib.itembuilder.parts;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemGlow implements ItemPart {
	private boolean glow;

	public ItemGlow(String constructor) {
		this.glow = (constructor.equalsIgnoreCase("glow:true"));
	}

	public void send(ItemStack item) {
		if ((item != null) && (item.getType() != org.bukkit.Material.AIR) && (this.glow)) {
			ItemMeta meta = item.getItemMeta();
			meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ATTRIBUTES });
			meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_ENCHANTS });
			meta.addItemFlags(new ItemFlag[] { ItemFlag.HIDE_POTION_EFFECTS });
			item.setItemMeta(meta);
		}
	}
}
