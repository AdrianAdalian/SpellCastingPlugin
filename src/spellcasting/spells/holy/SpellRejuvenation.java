package spellcasting.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellRejuvenation extends BaseSpell
{

	public SpellRejuvenation()
	{
		super(Material.SNOWBALL, "§r§7§ko§r§7§lSpell: §r§fRejuvenation§r§7§ko§r", 15, false, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fEmit a §r§ahealing§r§f aura within a small radius.","§r§aHeal§r§f 4 hearts over 10 seconds to players within radius.","§r§fRange: 15 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		if (event.getPlayer().getNearbyEntities(15, 15, 15).size() == 0)
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(15, 15, 15)) 
		{
			if (target instanceof Player)
	    	{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
	    		((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 1));
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
