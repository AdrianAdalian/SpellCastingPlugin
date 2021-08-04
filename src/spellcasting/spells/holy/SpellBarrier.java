package spellcasting.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellBarrier extends BaseSpell
{

	public SpellBarrier()
	{
		super(Material.SNOWBALL, "§r§7§ko§r§7§lSpell: §r§fBarrier§r§7§ko§r", 10, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fProtect the caster by raising a barrier around them.","§r§fApply a full health bar of absorption.","§r§fDuration: 20 seconds.","§r§fMana cost: 10 §r§9mana§r§f.");
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
		
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 400, 4));
		
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
