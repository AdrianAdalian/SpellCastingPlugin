package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.spells.BaseSpell;

public class SpellOverclockProtocol extends BaseSpell
{

	public SpellOverclockProtocol()
	{
		super(Material.RED_DYE, "§r§7§ko§r§7§lSpell: §r§fOverclock Protocol§r§7§ko§r", 20, true, "§r§fElement: §r§cFire§r§f.","§r§fDrastically overclocks caster's offensive","§r§fperformance granting a 200% §r§cdamage§r§f increase.","§r§fAlso slightly boosts interact speed.","§r§fDuration: 30 seconds.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false; 
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, null);
		
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 3));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 0));
		
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 605);	
		return true; 
	}
}
