package spellcasting.spells.geo;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellNaturesGift extends BaseSpell
{

	public SpellNaturesGift()
	{
		super(Material.LILY_OF_THE_VALLEY, "§r§e§ko§r§e§lRelic: §r§fNature's Gift§r§e§ko§r", 20, true, "§r§fElement: §r§6Geo§r§f.","§r§f§oA lily, blessed by the forces of §r§6Geo§r§f§o.","§r§fBoosts the growth ratio of all life around the caster.","§r§fAlso §aheals §r§fcaster for 2 hearts.","§r§fRange: Radial 10 square meters.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false;
		}
		int radius = 10; 
			try
			{
				event.getPlayer().setHealth(event.getPlayer().getHealth()+4);		
			}
			catch(IllegalArgumentException e)
			{			
				event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
			}	
		
		for (int iy = (radius * -1); iy < (radius * 2); iy++)
		{
			for (int ix = (radius * -1); ix < (radius * 2); ix++)
			{
				for (int iz = (radius * -1); iz < (radius * 2); iz++)
				{
					
					Block target1 = event.getPlayer().getWorld().getBlockAt(event.getPlayer().getLocation().add(new Location(event.getPlayer().getWorld(), ix, iy, iz)));
						
					if (target1.getBlockData() != null)
					{
						if (target1.getBlockData() instanceof Ageable) // org.bukkit.blockdata.Ageable, not org.bukkit.entity.Ageable
						{
							
							event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
							
							Ageable data = (Ageable) target1.getBlockData();
							data.getMaximumAge(); 
							data.setAge(data.getMaximumAge());
							target1.setBlockData(data);
							return true;
						}
					}	
				}
			}
		}
		return true;
	}
}
