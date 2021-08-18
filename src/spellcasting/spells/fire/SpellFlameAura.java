package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
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
		
		if (event.getPlayer().getNearbyEntities(10, 10, 10).size() == 0)
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, null);
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
		long time = System.currentTimeMillis();
		new BukkitRunnable() 
		{
			@Override
			public void run() 
			{		
				if (System.currentTimeMillis()-time >= 10000) //has a max time of 10 seconds.
				{
					this.cancel();
					return;
				} 
				
				for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10)) 
				{
					
					target.setFireTicks(100);
				}
			}
		}.runTaskTimer(Zenith.getInstance(), 0, 20);
		
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
				Source_Particles.drawSphereCloud(event.getPlayer().getLocation(), 10, 10, 5, 5, Particle.FLAME, null);
			}
		}.runTaskTimer(Zenith.getInstance(), 0, 5);
		return true;
	}	
}
