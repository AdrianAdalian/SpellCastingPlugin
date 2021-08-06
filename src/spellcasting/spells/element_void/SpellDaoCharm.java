package spellcasting.spells.element_void;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellDaoCharm extends BaseSpell
{

	public SpellDaoCharm()
	{
		super(Material.CLOCK, "§r§e§ko§r§e§lRelic: §r§fDao Charm§r§e§ko§r", 100, true, "§r§fElement: §r§3§lVOID§r§f.","§r§fA pocket watch,","§r§fcrafted using the forces of the §r§3§lVOID§r§f.","§r§fThis item has the power to swap","§r§6Day §r§fwith §r§7Night §r§fand vice versa.","§r§fMana cost: 100 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		long time = Bukkit.getWorlds().get(0).getTime();
		
		if(time >= 0 && time <= 12000)
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setTime(12000);
			//Sets the time to Sunset.
			return true;
		}
		if(time >=12005 && time <= 24000)
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setTime(0);
			//Sets the time to Sunrise.
			return true;
		}
		return false;
	}
}
