package spellcasting.divineweapon.weapon_recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.divineweapon.weapon_spell_item.DivineWeapon_WandOfFire;
import spellcasting.spells.BaseSpell;

public class WeaponRecipe_WandOfFire
{
static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell WandOfFire = new DivineWeapon_WandOfFire();
		final_item = WandOfFire.toIcon();
	}
	
	public static void Register()
	{
		
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "divine_weapon_wand_of_fire");
		ShapelessRecipe recipe = new ShapelessRecipe(key, final_item);
		
		recipe.addIngredient(Material.STICK);
		recipe.addIngredient(Material.BLAZE_POWDER);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
