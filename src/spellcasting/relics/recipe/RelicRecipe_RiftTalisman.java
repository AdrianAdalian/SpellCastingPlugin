package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.storm.SpellRiftTalisman;

public class RelicRecipe_RiftTalisman
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellRiftTalisman = new SpellRiftTalisman();
		final_item = SpellRiftTalisman.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_rift_talisman");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("NGN","PSP","NIN");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('P', Material.PAPER);
		recipe.setIngredient('G', Material.STRING);
		recipe.setIngredient('I', Material.GLOW_INK_SAC);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
