package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.spells.BaseSpell;

public class SpellHeatWave extends BaseSpell
{

	public SpellHeatWave()
	{
		super(Material.BLAZE_POWDER, "§r§7§ko§r§7§lSpell: §r§fHeat Wave§r§7§ko§r", 15, false, "§r§fElement: §r§cFire§r§f.","§r§fSet all targets within a small radius ablaze.","§r§fDeals 7 hearts of §r§cdamage§r§f over 10 seconds to each target.","§r§fRange: 10 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
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
		event.getPlayer().getWorld().spawnParticle(Particle.FLAME, event.getPlayer().getLocation(), 20);
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 1, 1);
		
		for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10)) 
		{
			target.setFireTicks(200);
		}
		return true; 
	}
}
