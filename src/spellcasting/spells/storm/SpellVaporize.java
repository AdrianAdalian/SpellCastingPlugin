package spellcasting.spells.storm;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellVaporize extends BaseSpell
{

	public SpellVaporize()
	{
		super(Material.PURPLE_DYE, "§r§7§ko§7§lSpell: §r§fVaporize§r§7§ko§r", 25, true, "§r§fElement: §r§dStorm§r§f.","§r§fSummons three consecutive lightning bolts at target.","§r§fRange: 50 meters.","§r§fDeals 7.5 hearts of §r§cdamage§r§f.","§r§fMana cost: 25 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		int TARGETRANGE = 50 ;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		if (target.getType().equals(Material.AIR))
		{
			return false;			
		}
		Entity target1 = getNearestEntityInSight(event.getPlayer(), 50);
		event.getPlayer().getWorld().strikeLightning(target1.getLocation()) ;		
		
		new BukkitRunnable()
		{
		  @Override
		  public void run()
		  {
			  event.getPlayer().getWorld().strikeLightning(target1.getLocation()) ;
		  }
		}.runTaskLater(Zenith.getInstance(), 20);
		new BukkitRunnable()
		{
		  @Override
		  public void run()
		  {
			  event.getPlayer().getWorld().strikeLightning(target1.getLocation()) ;
		  }
		}.runTaskLater(Zenith.getInstance(), 40);	
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
