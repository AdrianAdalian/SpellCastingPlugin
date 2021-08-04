package spellcasting.spells.element_void;

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

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellTelekinesis extends BaseSpell
{

	public SpellTelekinesis()
	{
		super(Material.CYAN_DYE, "§r§7§ko§r§7§lSpell: §r§fTelekinesis§r§7§ko§r", 20, true, "§r§fElement: §r§3§lVOID§r§f.","§r§fLevitate a target into the air,","§r§fdamaging them at their decent.","§r§fDuration: 3 seconds.","§r§fRange: 10 meters.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage("Invalid Cast Method.");
			return false;
		}
		
		Entity target = getNearestEntityInSight(event.getPlayer(), 10);
		
		if(target == null) 
		{
			PrintUtils.sendMessage("Invalid Target.");
			return false;
		}
		
		if(target instanceof LivingEntity) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, SoundCategory.MASTER, 1, 1);
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 4));
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
