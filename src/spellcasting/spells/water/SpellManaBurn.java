package spellcasting.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellManaBurn extends BaseSpell
{

	public SpellManaBurn()
	{
		super(Material.MAGMA_CREAM, "§r§7§ko§r§7§lSpell: §r§fMana Burn§r§7§ko§r", 25, true, "§r§fElement: §r§9Water§r§f.","§r§fBurn a large portion of the caster's mana","§r§fwhile granting increased damage output,","§r§fmovement and interact speeds for a short time.","§r§fThenafter, suffer a depression similar to those effects.","§r§fDuration of buffs: 10 seconds.","§r§fDuration of debuffs: 10 seconds.","§r§fMana cost: 25 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}	
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_ACTIVATE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 1));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 1));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 200, 1));
		
		 new BukkitRunnable()
		 {
			@Override
			public void run()
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_DEACTIVATE, SoundCategory.MASTER, 1, 1);
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1));
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 1));
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 1));
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200, 1));
			}
		 }.runTaskLater(Zenith.getInstance(), 205);
		 
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_ACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 410);
		return true;
	}
}
