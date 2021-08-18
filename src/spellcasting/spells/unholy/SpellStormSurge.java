package spellcasting.spells.unholy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellStormSurge extends BaseSpell
{

	public SpellStormSurge()
	{
		super(Material.ENCHANTED_BOOK, "§r§f§ko§r§fEmpoweredTome: StormSurge§r§f§ko§r", 25, false, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fSummons lightning onto all enemies within a small radius.","§r§4Drain §r§f1/2 hearts health for each target hit.","§r§fRange: 10 meters.","§r§fDeals 2.5 hearts of §r§cdamage §r§fper lightning bolt.","§r§fMana cost: 25 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		if (event.getPlayer().getNearbyEntities(10, 10, 10).size() == 0)
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10))
		{
			
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			
			event.getPlayer().getWorld().strikeLightning(target.getLocation());
			
			try
			{
				event.getPlayer().setHealth(event.getPlayer().getHealth()+1);		
			}
			catch(IllegalArgumentException e)
			{
				event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
			}	
		}
		return true;
	}
}

