package spellcasting.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.AbstractArrow.PickupStatus;
import org.bukkit.entity.Arrow;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellMagicArrow extends BaseSpell
{

	public SpellMagicArrow()
	{
		super(Material.SPECTRAL_ARROW, "§r§e§ko§r§e§lRelic: §r§fMagic Arrow§r§e§ko§r", 5, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fSummons a wooden arrow.","§r§fDeals 1 heart of §r§cdamage§r§f.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Arrow arrow = event.getPlayer().launchProjectile(Arrow.class);
		arrow.setPickupStatus(PickupStatus.DISALLOWED);
		arrow.setCritical(false);
		arrow.setKnockbackStrength(1);
		arrow.setDamage(2);	
		return true;
	}
}
