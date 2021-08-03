package spellcasting.spells.unholy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellDamagingForce extends BaseSpell
{

	public SpellDamagingForce()
	{
		super(Material.ENCHANTED_BOOK, "§r§f§ko§r§fEmpoweredTome: Damaging Force§r§f§ko§r", 5, false, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fEmits a brutal radial force.","§r§fRange: 4 meters.","§r§fDeals 2 hearts of §r§cdamage§r§f.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(4, 4, 4))
		{
			
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			
			if (target instanceof Damageable)
			{
				((Damageable) target).damage(4, event.getPlayer());
				return true;
			}
		}
		return false;
	}
}
