package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.unholy.SpellSkullOfNight;

public class RelicRecipe_SkullOfKnight
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellSkullOfKnight = new SpellSkullOfNight();
		final_item = SpellSkullOfKnight.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_skull_of_knight");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("BIB","PSP","BIB");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('B', Material.BONE);
		recipe.setIngredient('I', Material.NETHERITE_INGOT);
		recipe.setIngredient('P', Material.NETHERITE_SCRAP);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
