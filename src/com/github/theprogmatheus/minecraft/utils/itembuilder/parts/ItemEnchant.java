package com.github.theprogmatheus.minecraft.utils.itembuilder.parts;

import org.bukkit.inventory.ItemStack;

public class ItemEnchant implements ItemPart {
	private org.bukkit.enchantments.Enchantment enchant;
	private Integer level;

	public ItemEnchant(String constructor) {
		try {
			if (constructor.contains(":")) {
				constructor = constructor.toUpperCase();
				constructor = constructor.replace("SHARPNESS", "DAMAGE_ALL");
				constructor = constructor.replace("UNBREAKING", "DURABILITY");
				constructor = constructor.replace("FORTUNE", "LOOT_BONUS_BLOCKS");
				constructor = constructor.replace("LOOTING", "LOOT_BONUS_MOBS");
				constructor = constructor.replace("EFFICIENCY", "DIG_SPEED");
				constructor = constructor.replace("POWER", "ARROW_DAMAGE");
				constructor = constructor.replace("INFINITY", "ARROW_INFINITE");
				constructor = constructor.replace("PROTECTION", "PROTECTION_ENVIRONMENTAL");
				String[] split = constructor.split(":");
				this.enchant = org.bukkit.enchantments.Enchantment.getByName(split[0]);
				this.level = Integer.valueOf(split[1]);
			}
		} catch (Exception localException) {
		}
	}

	public void send(ItemStack item) {
		if ((item != null) && (this.level != null) && (this.enchant != null) && (this.level.intValue() > 0)
				&& (!item.getType().equals(org.bukkit.Material.AIR))) {
			org.bukkit.inventory.meta.ItemMeta meta = item.getItemMeta();
			if (item.getType().equals(org.bukkit.Material.ENCHANTED_BOOK)) {
				((org.bukkit.inventory.meta.EnchantmentStorageMeta) meta).addStoredEnchant(this.enchant,
						this.level.intValue(), true);
			} else {
				meta.addEnchant(this.enchant, this.level.intValue(), true);
			}
			item.setItemMeta(meta);
		}
	}
}
