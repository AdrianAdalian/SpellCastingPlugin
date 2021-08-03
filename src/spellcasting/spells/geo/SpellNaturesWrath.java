package spellcasting.spells.geo;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellNaturesWrath extends BaseSpell
{

	public SpellNaturesWrath()
	{
		super(Material.CRIMSON_FUNGUS, "§r§e§ko§r§e§lRelic: §r§fNature's Wrath§r§e§ko§r", 25, true, "§r§fElement: §r§6Geo§r§f.","§r§f§oA mushroom, defiled by the forces of §r§6Geo§r§f§o.","§r§fDegrades the growth ratio of all life around the caster.","§r§fAlso deals 2 hearts of §r§cdamage§r§f within the cast radius.","§r§fRange: Radial 10 square meters.","§r§fMana cost: 25 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_NYLIUM_BREAK, SoundCategory.MASTER, 1, 1);
		
		int radius = 10;
		
		for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10))
		{
			
			if (target instanceof Damageable)
			{
				((Damageable) target).damage(4, event.getPlayer());
				return true;
			}
		}
		
		for (int iy = (radius * -1); iy < (radius * 2); iy++)
		{
			for (int ix = (radius * -1); ix < (radius * 2); ix++)
			{
				for (int iz = (radius * -1); iz < (radius * 2); iz++)
				{
					
					Block target = event.getPlayer().getWorld().getBlockAt(event.getPlayer().getLocation().add(new Location(event.getPlayer().getWorld(), ix, iy, iz)));
						
					if (target.getBlockData() != null)
					{
						if (target.getBlockData() instanceof Ageable) // org.bukkit.blockdata.Ageable, not org.bukkit.entity.Ageable
						{	
							Ageable data = (Ageable) target.getBlockData();
							if (data.getMaximumAge() == data.getAge())
							{
								
								data.setAge(0);
								target.setBlockData(data);
								return true;
							}
						}
					}	
				}
			}
		}	
		return true;
	}
}
