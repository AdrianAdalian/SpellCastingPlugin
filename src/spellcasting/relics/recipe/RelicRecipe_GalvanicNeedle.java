package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.storm.SpellGalvanicNeedle;

public class RelicRecipe_GalvanicNeedle
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellGalvanicNeedle = new SpellGalvanicNeedle();
		final_item = SpellGalvanicNeedle.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_galvanic_needle");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("ANQ","NSN","QNA");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('Q', Material.QUARTZ);
		recipe.setIngredient('A', Material.AMETHYST_SHARD);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
