package spellcasting.divineweapon.weapon_recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.divineweapon.weapon_spell_item.DivineWeapon_Penance;
import spellcasting.spells.BaseSpell;

public class WeaponRecipe_Penance
{

	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell Penance = new DivineWeapon_Penance();
		final_item = Penance.toIcon();
	}
	
	public static void Register()
	{
		
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "divine_weapon_penance");
		ShapelessRecipe recipe = new ShapelessRecipe(key, final_item);
		
		recipe.addIngredient(Material.BOW);
		recipe.addIngredient(Material.GLOWSTONE_DUST);
		
		Bukkit.addRecipe(recipe);

	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
