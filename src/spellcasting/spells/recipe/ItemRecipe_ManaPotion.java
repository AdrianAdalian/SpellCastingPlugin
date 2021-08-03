package spellcasting.spells.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.ItemUtils;

public class ItemRecipe_ManaPotion
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		final_item = new ItemStack(Material.POTION);
		ItemUtils.applyName(final_item, "§r§9Mana §r§fPotion");
		ItemUtils.applyLore(final_item, "§r§fReplenishes a small portion of §r§9Mana§r§f.");
		ItemUtils.saveToNamespacedKey(final_item, "ManaPotionID", "true");
		
		ItemMeta meta = final_item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 0, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		final_item.setItemMeta(meta);
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "basic_mana_potion");
		ShapelessRecipe recipe = new ShapelessRecipe(key, final_item);

		recipe.addIngredient(Material.POTION);
		recipe.addIngredient(Material.LAPIS_LAZULI);
		
		Bukkit.addRecipe(recipe);
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
