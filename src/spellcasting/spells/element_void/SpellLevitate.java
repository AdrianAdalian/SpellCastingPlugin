package spellcasting.spells.element_void;

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

public class SpellLevitate extends BaseSpell
{

	public SpellLevitate()
	{
		super(Material.CYAN_DYE, "§r§7§ko§r§7§lSpell: §r§fLevitate§r§7§ko§r", 10, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fAlter the effects of gravity around the caster,","§r§fallowing them to briefly levitate and fall safely back down.","§r§fDuration of Levitation: 15 seconds.","§r§fDuration of Slow Falling: 3 seconds.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 300, 0));
		
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 60, 0));
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 305);	
		return true;
	}
}
