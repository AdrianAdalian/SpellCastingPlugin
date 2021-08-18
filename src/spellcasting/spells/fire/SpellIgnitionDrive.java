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

public class SpellIgnitionDrive extends BaseSpell
{

	public SpellIgnitionDrive()
	{
		super(Material.RED_DYE, "§r§7§ko§r§7§lSpell: §r§fIgnition Drive§r§7§ko§r", 10, false, "§r§fElement: §r§cFire§r§f.","§r§fOverclocks caster's offensive","§r§fperformance granting a 150% §r§cdamage§r§f increase.","§r§fDuration: 20 seconds.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
	
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false; 
		}
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, null);
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 1));
			
			
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 405);	
		return true;
	}
}
