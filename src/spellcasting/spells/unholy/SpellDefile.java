package spellcasting.spells.unholy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellDefile extends BaseSpell
{

	public SpellDefile()
	{
		super(Material.BLACK_DYE, "§r§7§ko§r§7§lSpell: §r§fDefile§r§7§ko§r", 20, true, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fDefiles all within close proximity.","§r§fBlind and Slow all nearby targets.","§r§fDuration: 10 seconds.","§r§fRange: 10 meters.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10)) 
		{
			if (target instanceof LivingEntity)
	    	{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0));
	    	}  
			new BukkitRunnable()
			{
			  @Override
			  public void run()
			  {
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			  }
			}.runTaskLater(Zenith.getInstance(), 205);	
		}	
		return true;
	}
}
