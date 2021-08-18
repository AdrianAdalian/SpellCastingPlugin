package spellcasting.divineweapon.weapon_recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.divineweapon.weapon_spell_item.DivineWeapon_StaffOfElements;
import spellcasting.spells.BaseSpell;

public class WeaponRecipe_StaffOfElements
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell staffofelements = new DivineWeapon_StaffOfElements();
		final_item = staffofelements.toIcon();
	}
	
	public static void Register()
	{
		
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "divine_weapon_staff_of_elements");
		ShapelessRecipe recipe = new ShapelessRecipe(key, final_item);
		
		recipe.addIngredient(Material.STICK);
		recipe.addIngredient(Material.BLAZE_POWDER);
		recipe.addIngredient(Material.ENDER_PEARL);
		recipe.addIngredient(Material.CLAY_BALL);
		recipe.addIngredient(Material.LAPIS_LAZULI);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
