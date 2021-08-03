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

import spellcasting.spells.BaseSpell;

public class SpellExtricate extends BaseSpell
{

	public SpellExtricate()
	{
		super(Material.WHITE_DYE, "§r§7§ko§r§7§lSpell: §r§fExtricate§r§7§ko§r", 20, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fAmplify the caster's normal health pool.","§r§fAdd a second full health bar for 1 minute.","§r§fAlso restores saturation over 5 seconds.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
	
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 0));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1200, 4));
		
		new BukkitRunnable()
		{
		  @Override
		  public void run()
		  {
			  event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
		  }
		}.runTaskLater(Zenith.getInstance(), 1205);
		return true;
	}
}
