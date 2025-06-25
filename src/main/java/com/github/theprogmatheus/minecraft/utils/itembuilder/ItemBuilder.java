package com.github.theprogmatheus.minecraft.utils.itembuilder;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import com.github.theprogmatheus.minecraft.utils.itembuilder.parts.ItemEffect;
import com.github.theprogmatheus.minecraft.utils.itembuilder.parts.ItemEnchant;
import com.github.theprogmatheus.minecraft.utils.itembuilder.parts.ItemGlow;
import com.github.theprogmatheus.minecraft.utils.itembuilder.parts.ItemLore;
import com.github.theprogmatheus.minecraft.utils.itembuilder.parts.ItemName;
import com.github.theprogmatheus.minecraft.utils.itembuilder.parts.ItemSkull;
import com.github.theprogmatheus.minecraft.utils.itembuilder.parts.ItemSkullUrl;

public class ItemBuilder {
	private ItemStack itemStack;

	@SuppressWarnings("deprecation")
	public ItemBuilder(String constructor) {

		if (constructor == null || constructor.isEmpty())
			throw new IllegalArgumentException("The ItemBuilder constructor can't be null.");

		try {
			Material itemStackMaterial = Material.AIR;
			short itemStackData = 0;
			int itemStackAmount = 1;

			String[] constructorParts = new String[] { constructor };
			if (constructor.contains(" "))
				constructorParts = constructor.split(" ");

			String[] itemSources = new String[] { constructorParts[0] };
			String firstSource = itemSources[0];

			if (firstSource.contains(":")) {
				String[] firstSourceSplit = firstSource.split(":");
				itemSources = new String[2];
				itemSources[0] = firstSourceSplit[0];
				itemSources[1] = firstSourceSplit[1];
				firstSource = itemSources[0];
			}

			try {
				itemStackMaterial = Material.getMaterial(Integer.parseInt(firstSource));
			} catch (Exception e1) {
				try {
					itemStackMaterial = Material.valueOf(firstSource.toUpperCase());
				} catch (Exception e2) {
					try {
						String materialName = firstSource.toLowerCase();
						itemStackMaterial = Arrays.asList(Material.values()).stream()
								.filter(material -> material.name().replace("_", "").equalsIgnoreCase(materialName))
								.findFirst().orElse(null);
					} catch (Exception e4) {
						itemStackMaterial = null;
					}
				}
			}

			if (itemSources.length >= 2) {
				try {
					itemStackData = Short.parseShort(itemSources[1]);
				} catch (Exception exception) {
					itemStackData = 0;
				}
			}

			if (constructorParts.length >= 2) {

				try {
					itemStackAmount = Integer.parseInt(constructorParts[1]);
				} catch (Exception exception) {
					itemStackAmount = 1;
				}
			}

			this.itemStack = new ItemStack(itemStackMaterial, itemStackAmount, itemStackData);
			if (constructorParts.length >= 1) {
				for (int i = 1; i < constructorParts.length; i++) {
					String compound = constructorParts[i];
					new ItemEffect(compound).send(this.itemStack);
					new ItemEnchant(compound).send(this.itemStack);
					new ItemName(compound).send(this.itemStack);
					new ItemLore(compound).send(this.itemStack);
					new ItemSkullUrl(compound).send(this.itemStack);
					new ItemSkull(compound).send(this.itemStack);
					new ItemGlow(compound).send(this.itemStack);
				}
			}
		} catch (Exception exception) {
		}
	}

	public ItemStack toItemStack() {
		return this.itemStack;
	}
}
