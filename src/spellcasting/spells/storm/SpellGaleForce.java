package spellcasting.spells.storm;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellGaleForce extends BaseSpell
{

	public SpellGaleForce()
	{
		super(Material.STRING, "§r§7§ko§r§7§lSpell: §r§fGaleForce§r§7§ko§r", 10, true, "§r§fElement: §r§dStorm§r§f.","§r§fPushes the target a great distance away.","§r§fRange: 7 meters.","§r§fDeals 2 hearts of §r§cdamage§r§f.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		//PrintUtils.log(event.getAction().name() , InfoType.INFO) ; 
		//Prints the action every time it is used; good for debugging.
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		Entity target = getNearestEntityInSight(event.getPlayer(), 7);
		
		if(target==null) 
		{
			return false;
		}
		
		target.setVelocity(target.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
		
		if (target instanceof Damageable)
		{
			((Damageable) target).damage(4, event.getPlayer());
			return true;
		}
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

