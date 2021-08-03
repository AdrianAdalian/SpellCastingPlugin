package spellcasting.spells.water;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellSuffocate extends BaseSpell
{

	public SpellSuffocate()
	{
		super(Material.BLUE_DYE, "§r§7§ko§r§7§lSpell: §r§fSuffocate§r§7§ko§r", 25, false, "§r§fElement: §r§9Water§r§f.","§r§fSuffocate the target player and as they struggle,","§r§fapply slowness, weakness, fatigue, and blindness.","§r§fDeals 4 hearts of §r§cdamage§r§f.","§r§fDuration: 10 seconds.","§r§fRange: 10 meters.","§r§fMana cost: 25 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		Entity target = getNearestEntityInSight(event.getPlayer(), 10);
		
		if (!(target instanceof Player)) 
		{
			return false;
		}
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
			((Player) target).playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_ENTER, SoundCategory.MASTER, 1, 1);
			
			((Player) target).damage(8, event.getPlayer());
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 2));
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
				((Player) target).playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
		   }
		 }.runTaskLater(Zenith.getInstance(), 205);
		 return true;
	}
	private Entity getNearestEntityInSight(Player player, int range) 
	{
		
	    ArrayList<Entity> entities = (ArrayList<Entity>) player.getNearbyEntities(range, range, range);
	    ArrayList<Block> sightBlock = null;
	    try 
	    {
	        sightBlock = (ArrayList<Block>) player.getLineOfSight(null, range);
	    } catch (IllegalStateException error) 
	    {
	        return null;
	    }
	     
	    ArrayList<Location> sight = new ArrayList<Location>();
	    for (int i = 0;i<sightBlock.size();i++)
	        sight.add(sightBlock.get(i).getLocation());
	    for (int i = 0;i<sight.size();i++) {
	        for (int k = 0;k<entities.size();k++) {
	            if (entities.get(k) instanceof LivingEntity && !(entities.get(k) instanceof ArmorStand)) {
	                if (Math.abs(entities.get(k).getLocation().getX()-sight.get(i).getX())<1.3) {
	                    if (Math.abs(entities.get(k).getLocation().getY()-sight.get(i).getY())<1.5) {
	                        if (Math.abs(entities.get(k).getLocation().getZ()-sight.get(i).getZ())<1.3) {
	                                
	                        	return entities.get(k);
	                        	
	                        }
	                    }
	                }
	            }
	        }
	    }
	    	return null; // Return null if no entity was found
	}
}
