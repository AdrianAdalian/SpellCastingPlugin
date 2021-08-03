package spellcasting.relics.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;
import spellcasting.spells.holy.SpellHeal;

public class RelicRecipe_HealingTear
{
	static ItemStack final_item;
	
	public static void Init() 
	{
		BaseSpell SpellHeal = new SpellHeal();
		final_item = SpellHeal.toIcon();
	}
	
	public static void Register()
	{
		NamespacedKey key = new NamespacedKey(Zenith.getInstance(), "spell_relic_healing_tear");
		ShapedRecipe recipe = new ShapedRecipe(key, final_item);

		recipe.shape("NNN","DSI","NNN");

		recipe.setIngredient('S', Material.NETHER_STAR);
		recipe.setIngredient('D', Material.DRAGON_BREATH);
		recipe.setIngredient('I', Material.GLOW_INK_SAC);
		recipe.setIngredient('N', Material.AIR);
		
		Bukkit.addRecipe(recipe);
		
	}
	public static ItemStack getFinal_item()
	{
		return final_item;
	}
}
