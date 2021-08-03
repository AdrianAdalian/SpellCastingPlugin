package spellcasting.spells.holy;

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

public class SpellAccolades extends BaseSpell
{

	public SpellAccolades()
	{
		super(Material.NETHER_STAR, "§r§7§ko§r§7§lSpell: §r§fAccolades§r§7§ko§r", 25, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fAllauds the target player accolades from the angels.","§r§fEffects: Speed, Haste, Strength, and Saturation.","§r§fRange: 20 meters.","§r§fDuration: 20 seconds.","§r§fMana cost: 25 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false; 
		}
		
		Entity target = getNearestPlayerInSight(event.getPlayer(), 20);
		
		if (!(target instanceof Player)) 
		{
			return false;
		}
			
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
			((Player) target).playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 400, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 400, 2));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 2));
			
			new BukkitRunnable()
			{
				@Override
				public void run()
				{
				  	
				  	event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
					((Player) target).playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
				
				}
			}.runTaskLater(Zenith.getInstance(), 205);
			return true;
	}
	private Entity getNearestPlayerInSight(Player player, int range) 
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
