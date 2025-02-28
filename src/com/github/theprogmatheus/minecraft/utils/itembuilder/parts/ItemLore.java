package com.github.theprogmatheus.minecraft.utils.itembuilder.parts;

import org.bukkit.inventory.ItemStack;

public class ItemLore implements ItemPart {
	private String lore;

	public ItemLore(String constructor) {
		try {
			if (constructor.startsWith("lore:")) {
				this.lore = constructor.replace("lore:", "").replace("&", "�").replace("_", " ");
			}
		} catch (Exception localException) {
		}
	}

	public void send(ItemStack item) {
		if ((item != null) && (!item.getType().equals(org.bukkit.Material.AIR)) && (getLore() != null)) {
			java.util.List<String> lore = new java.util.ArrayList<String>();
			org.bukkit.inventory.meta.ItemMeta meta = item.getItemMeta();
			if (meta.getLore() != null)
				lore = meta.getLore();
			lore.add(getLore());
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
	}

	public String getLore() {
		return this.lore;
	}
}
