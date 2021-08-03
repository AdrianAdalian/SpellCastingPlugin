package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.element_void.SpellDaoCharm;

public class RelicRecipe_DaoCharm
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellDaoCharm = new SpellDaoCharm();
		final_item = SpellDaoCharm.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_dao_charm");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("PGP","GSG","PGP");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('P', Material.NETHERITE_SCRAP);
		recipe.setIngredient('G', Material.GOLD_INGOT);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
