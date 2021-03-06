package spellcasting.spells.fire;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.module.java.annotations.Unimplemented;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.spells.BaseSpell;
@Unimplemented
public class SpellIgnite extends BaseSpell
{
	
	public SpellIgnite()
	{
		super(Material.BLAZE_POWDER, "§r§7§ko§r§7§lSpell: §r§fIgnite§r§7§ko§r", 5, false, "§r§fElement: §r§cFire§r§f.","§r§fSet any target ablaze within a small radius.","§r§fDeals 5 hearts of §r§cdamage§r§f over 8 seconds.","§r§fRange: 5 meters.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
				
		LivingEntity target = (LivingEntity) getNearestEntityInSight(event.getPlayer(), 5);
		
		if (target == null) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, null);
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 1, 1);
		
		target.setFireTicks(160);
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
