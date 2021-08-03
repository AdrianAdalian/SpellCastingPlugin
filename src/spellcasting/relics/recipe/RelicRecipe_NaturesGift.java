package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.geo.SpellNaturesGift;

public class RelicRecipe_NaturesGift
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellNaturesGift = new SpellNaturesGift();
		final_item = SpellNaturesGift.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_natures_gift");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("EBE","BSB","EBE");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('B', Material.BONE_MEAL);
		recipe.setIngredient('E', Material.EMERALD);
		
		Bukkit.addRecipe(recipe);
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
