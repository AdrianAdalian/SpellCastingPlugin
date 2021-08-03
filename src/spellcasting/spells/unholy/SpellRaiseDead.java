package spellcasting.spells.unholy;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ZombieVillager;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellRaiseDead extends BaseSpell
{
	
	public SpellRaiseDead()
	{
		super(Material.BONE, "§r§7§ko§r§7§lSpell: §r§fRaise Dead§r§7§ko§r", 20, false, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fSacrifice 1 heart of caster's life force.","§r§fReanimates any zombie villager to their living counter part.","§r§fRange: 5 meters.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		Entity target = getNearestEntityInSight(event.getPlayer(), 5);
	
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
	
		if(target == null) 
		{
			return false;
		}
		
		if (target.getType().equals(EntityType.ZOMBIE_VILLAGER))
		{
			
			event.getPlayer().damage(2);
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
			((ZombieVillager) target).setConversionTime(0);
			return true;
		}
		return false;
	}
	
	protected Entity getNearestEntityInSight(Player player, int range) 
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
