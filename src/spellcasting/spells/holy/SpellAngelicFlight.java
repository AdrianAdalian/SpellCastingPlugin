package spellcasting.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellAngelicFlight extends BaseSpell
{

	public SpellAngelicFlight()
	{
		super(Material.NETHER_STAR, "§r§7§ko§r§7§lSpell: §r§fAngelic Flight§r§7§ko§r", 20, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fGrants the caster temporary flight.","§r§fDuration: 20 seconds.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false; 
		}
		
		event.getPlayer().setAllowFlight(true);
		event.getPlayer().setFlying(true);
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_AMBIENT, SoundCategory.MASTER, 1, 1);
		
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
			  	
				event.getPlayer().setAllowFlight(false);
			  	event.getPlayer().setFlying(false);
			  
			  	event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			
			}
		}.runTaskLater(Zenith.getInstance(), 405);
		return true;
	}
}
