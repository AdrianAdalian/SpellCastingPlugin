package spellcasting.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellHeal extends BaseSpell
{

	public SpellHeal()
	{
		super(Material.GHAST_TEAR, "§r§e§ko§r§e§lRelic: §r§fHealing Tear§r§e§ko§r", 20, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§f§oIt's a drop of healing liquid.","§r§aHeals §r§f5 hearts to self.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}	
		try
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			
			event.getPlayer().setHealth(event.getPlayer().getHealth()+10);		
		}
		catch(IllegalArgumentException e)
		{			
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			
			event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
		}	
		return true;
	}
}
