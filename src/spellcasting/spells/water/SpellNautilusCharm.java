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

public class SpellNautilusCharm extends BaseSpell
{

	public SpellNautilusCharm()
	{
		super(Material.NAUTILUS_SHELL, "§r§e§ko§r§e§lRelic: §r§fNautilus Charm§r§e§ko§r", 20, true, "§r§fElement: §r§9Water§r§f.","§r§f§oA charm made by a long forgotten civilization.","§r§fGrants the caster increased mobility and visibility under water.","§r§fDuration: 30 seconds.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_ACTIVATE, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONDUIT_POWER, 600, 0));
		
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 605);
		return true;
	}	
}
