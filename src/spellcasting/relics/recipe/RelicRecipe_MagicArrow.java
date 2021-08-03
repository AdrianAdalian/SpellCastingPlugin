package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.holy.SpellMagicArrow;

public class RelicRecipe_MagicArrow
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellMagicArrow = new SpellMagicArrow();
		final_item = SpellMagicArrow.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_magic_arrow");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("NNQ","NSN","FNN");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('Q', Material.QUARTZ);
		recipe.setIngredient('F', Material.FEATHER);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
