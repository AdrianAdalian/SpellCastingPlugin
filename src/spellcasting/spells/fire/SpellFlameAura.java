package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellFlameAura extends BaseSpell
{

	public SpellFlameAura()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fFlame Aura§r§f§ko§r", 15, false, "§r§fElement: §r§cFire§r§f.","§r§fCast an aura of fire that periodically sets all within range ablaze.","§r§fDuration: 10 seconds.","§r§fRange: 10 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
	
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		if (event.getPlayer().getNearbyEntities(5, 5, 5).size() == 0)
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		long time = System.currentTimeMillis();
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{		
				if (System.currentTimeMillis()-time >= 10000) 
				{
					this.cancel();
					return;
				} 
				for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10)) 
				{
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
					target.setFireTicks(100);
				}
			}
		}.runTaskTimer(Zenith.getInstance(), 0, 20);
		return true;
	}	
}
