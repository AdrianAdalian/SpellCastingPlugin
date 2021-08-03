package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.water.SpellNautilusCharm;

public class RelicRecipe_NautilusCharm
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellNautilusCharm = new SpellNautilusCharm();
		final_item = SpellNautilusCharm.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_nautilus_charm");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("NIS","NKI","GNN");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('K', Material.STICK);
		recipe.setIngredient('G', Material.STRING);
		recipe.setIngredient('I', Material.IRON_NUGGET);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
