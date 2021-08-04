package spellcasting.spells.holy;

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
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellRadiance extends BaseSpell
{

	public SpellRadiance()
	{
		super(Material.SNOWBALL, "§r§7§ko§r§7§lSpell: §r§fRadiance§r§7§ko§r", 10, false, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fEmit a burst of divine energy within a radius.","§r§fCauses those effected to glow.","§r§fDuration: 20 seconds.","§r§fRange: 30 meters.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(30, 30, 30)) 
		{
			if (target instanceof LivingEntity)
	    	{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 400, 0));
	    	}
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
		return false;
	}
}
