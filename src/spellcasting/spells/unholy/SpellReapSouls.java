package spellcasting.spells.unholy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellReapSouls extends BaseSpell
{

	public SpellReapSouls()
	{
		super(Material.BLACK_DYE, "§r§7§ko§r§7§lSpell: §r§fReap Souls§r§7§ko§r", 10, true, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fReap the souls of any nearby entity.","§r§fAll within radius take 1 heart of §r§cdamage§r§f.","§r§4Drain§r§f 1/2 heart for each target.","§r§fRange: 10 meters.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		for (Entity target1 : event.getPlayer().getNearbyEntities(10, 10, 10)) 
		{
				
			if (target1 instanceof Damageable) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
				((Damageable) target1).damage(2, event.getPlayer());
				try 
				{
						event.getPlayer().setHealth(event.getPlayer().getHealth()+1);	
				}
				catch(IllegalArgumentException e)
				{
					event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
				}
				return true;
			}
		}
		return false;
	}
}