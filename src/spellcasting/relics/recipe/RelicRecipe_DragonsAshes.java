package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.fire.SpellDragonAshes;

public class RelicRecipe_DragonsAshes
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellDragonsAshes = new SpellDragonAshes();
		final_item = SpellDragonsAshes.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_dragon_ashes");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("GBG","ESE","GBG");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('G', Material.GUNPOWDER);
		recipe.setIngredient('E', Material.ENDER_EYE);
		recipe.setIngredient('B', Material.BLAZE_POWDER);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
