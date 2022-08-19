package spellcasting.spells.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.ItemUtils;

public class SpellRecipe_BookOfVoid
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		final_item = new ItemStack(Material.BOOK);
		ItemUtils.applyName(final_item, "§r§f§ko§r§f§lSpellBook: §r§fBook of §r§3§lVOID§r§f§ko§r");
		ItemUtils.applyLore(final_item, "§r§fElement: §r§3§lVOID§r§f.","§r§fA spell book containing unstable ethereal properties.","§r§fRight click to open the spellbook while in the hotbar.","§r§fLeft click to engage/disengage spells.");
		ItemUtils.saveToNamespacedKey(final_item, "SpellBookVoidID", "true");
		
		ItemMeta meta = final_item.getItemMeta();
		meta.addEnchant(Enchantment.DURABILITY, 0, true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		final_item.setItemMeta(meta);
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_book_void");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("BI", "FA");

		recipe.setIngredient('B', Material.BOOK);
		recipe.setIngredient('A', Material.ENDER_EYE);
		recipe.setIngredient('F', Material.FEATHER);
		recipe.setIngredient('I', Material.INK_SAC);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}