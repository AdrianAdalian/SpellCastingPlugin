package spellcasting.divineweapon.weapon_recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.divineweapon.weapon_spell_item.DivineWeapon_NetherScythe;
import spellcasting.spells.BaseSpell;

public class WeaponRecipe_NetherScythe
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell NetherScythe = new DivineWeapon_NetherScythe();
		final_item = NetherScythe.toIcon();
	}
	
	public static void Register()
	{
		
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "divine_weapon_nether_scythe");
		ShapelessRecipe recipe = new ShapelessRecipe(key, final_item);
		
		recipe.addIngredient(Material.NETHERITE_HOE);
		recipe.addIngredient(Material.WITHER_SKELETON_SKULL);
		
		Bukkit.addRecipe(recipe);

	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
