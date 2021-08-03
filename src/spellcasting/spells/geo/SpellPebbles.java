package spellcasting.spells.geo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_Pebbles;

public class SpellPebbles extends BaseSpell
{
	
	public SpellPebbles()
	{
		super(Material.COCOA_BEANS, "§r§7§ko§r§7§lSpell: §r§fPebbles§r§7§ko§r", 5, false, "§r§fElement: §r§6Geo§r§f.","§r§fHurl a group of small pebbles.","§r§fDeals 1 heart of §r§cdamage§r§f.","§r§fRange: 5 meters.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDER_PEARL_THROW, SoundCategory.MASTER, 1, 1);
		
		new SpellProjectile_Pebbles().launch(event.getPlayer());
		
		return true;
	}
}
