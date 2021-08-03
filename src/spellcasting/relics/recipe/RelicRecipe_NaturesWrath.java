package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.geo.SpellNaturesWrath;

public class RelicRecipe_NaturesWrath
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellNaturesWrath = new SpellNaturesWrath();
		final_item = SpellNaturesWrath.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_natures_wrath");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("CBC","BSB","CBC");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('B', Material.BONE_MEAL);
		recipe.setIngredient('C', Material.COAL);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
