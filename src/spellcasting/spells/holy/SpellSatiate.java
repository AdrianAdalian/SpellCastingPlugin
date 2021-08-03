package spellcasting.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spellcasting.spells.BaseSpell;

public class SpellSatiate extends BaseSpell
{

	public SpellSatiate()
	{
		super(Material.WHITE_DYE, "§r§7§ko§r§7§lSpell: §r§fSatiate§r§7§ko§r", 10, false, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fSatiates the caster.","§r§fRestore saturation points over 5 seconds.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
	
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 0));
		return true;
	}
}
