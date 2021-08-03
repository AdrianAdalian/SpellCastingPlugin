package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.unholy.SpellWitheringRose;

public class RelicRecipe_WitheringRose
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellWitheringRose = new SpellWitheringRose();
		final_item = SpellWitheringRose.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_withering_rose");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("GSG","NGN","NGN");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('G', Material.NETHERITE_SCRAP);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
