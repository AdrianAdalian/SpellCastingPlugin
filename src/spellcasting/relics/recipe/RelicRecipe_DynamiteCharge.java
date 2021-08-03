package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.fire.SpellDynamiteCharge;

public class RelicRecipe_DynamiteCharge
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellDynamiteCharge = new SpellDynamiteCharge();
		final_item = SpellDynamiteCharge.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_dynamite_charge");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("NBN","RSR","NKN");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		recipe.setIngredient('R', Material.BLAZE_ROD);
		recipe.setIngredient('K', Material.BRICK);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
