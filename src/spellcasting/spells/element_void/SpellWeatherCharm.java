package spellcasting.spells.element_void;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellWeatherCharm extends BaseSpell
{

	public SpellWeatherCharm()
	{
		super(Material.COMPASS, "§r§e§ko§r§e§lRelic: §r§fWeather Charm§r§e§ko§r", 100, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fAn enchanted compass,","§r§fcrafted using the forces of the §r§3§lVOID§r§f.","§r§fThis item has the power to swap current weather conditions.","§r§fMana cost: 100 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		boolean weather = Bukkit.getWorlds().get(0).isClearWeather();
		
		if(weather) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setStorm(true);
			Bukkit.getWorlds().get(0).setWeatherDuration(6000);
			return true;
		} 
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			Bukkit.getWorlds().get(0).setStorm(false);
			Bukkit.getWorlds().get(0).setThundering(false);
			Bukkit.getWorlds().get(0).setClearWeatherDuration(12000);
			return true;
	}
}
