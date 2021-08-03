package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.element_void.SpellWeatherCharm;

public class RelicRecipe_WeatherCharm
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellWeatherCharm = new SpellWeatherCharm();
		final_item = SpellWeatherCharm.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_weather_charm");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("APB","PSP","ZPK");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('P', Material.NETHERITE_SCRAP);
		recipe.setIngredient('K', Material.BRICK);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		recipe.setIngredient('A', Material.AMETHYST_SHARD);
		recipe.setIngredient('Z', Material.LAPIS_LAZULI);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
