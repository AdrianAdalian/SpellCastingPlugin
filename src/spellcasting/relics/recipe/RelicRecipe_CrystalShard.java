package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.water.SpellCrystalShard;

public class RelicRecipe_CrystalShard
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellCrystalShard = new SpellCrystalShard();
		final_item = SpellCrystalShard.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_crystal_shard");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("NPN","NSN","NPN");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('P', Material.QUARTZ);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
