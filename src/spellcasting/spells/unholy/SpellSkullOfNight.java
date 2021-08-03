package spellcasting.spells.unholy;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellSkullOfNight extends BaseSpell
{

	public SpellSkullOfNight()
	{
		super(Material.WITHER_SKELETON_SKULL, "§r§e§ko§r§e§lRelic: §r§fSkull of Night§r§e§ko§r", 15, true, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fDamage either target or nearby enemies.","§r§fDrain health for half the damage dealt.","§r§fTarget Range: 25 meters.","§r§fTarget Damage: Deals 4 hearts of §r§cdamage§r§f.","§r§fTarget Life Steal: §r§4Drain §r§f2 hearts.","§r§fAOE Range: 10 meters.","§r§fAOE Damage: Deals 1 hearts of §r§cdamage§r§f per entity.","§r§fAOE Life Steal: §r§4Drain §r§f 1/2 heart per entity.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		Entity target = getNearestEntityInSight(event.getPlayer(), 25);
		
		if (target == null) 
		{
			for (Entity target1 : event.getPlayer().getNearbyEntities(10, 10, 10)) 
			{
				
				if (target1 instanceof Damageable) 
				{
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
					((Damageable) target1).damage(2, event.getPlayer());
					try 
					{
						event.getPlayer().setHealth(event.getPlayer().getHealth()+1);	
					}
					catch(IllegalArgumentException e)
					{
						event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
					}
					return true;
				}
			}
		}
		
		if (target instanceof Damageable)
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
			((Damageable) target).damage(8, event.getPlayer());
			try 
			{
			event.getPlayer().setHealth(event.getPlayer().getHealth()+4);	
			}
			catch(IllegalArgumentException e)
			{
				event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
			}
			return true;
		}
		return false;
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