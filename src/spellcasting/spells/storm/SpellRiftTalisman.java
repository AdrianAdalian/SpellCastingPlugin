package spellcasting.spells.storm;

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
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellRiftTalisman extends BaseSpell
{

	public SpellRiftTalisman()
	{
		super(Material.NAME_TAG, "§r§e§ko§r§e§lRelic: §r§fRift Talisman§r§e§ko§r", 20, true, "§r§fElement: §r§dStorm§r§f.","§r§f§oA magic talisman with two unique effects.","§r§fTeleports caster between targets within a 100 block radius.","§r§fTeleports caster within a 50 block radius.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		Entity targetEntity = getNearestEntityInSight(event.getPlayer(), 100) ;
		
		if (targetEntity == null) 
		{
			
			int TARGETRANGE = 50 ;
			
			float YAW = event.getPlayer().getLocation().getYaw() ;
			float PITCH = event.getPlayer().getLocation().getPitch() ; //float is a variable that is a decimal, we can use this to get a rotated object/pitch/yaw.
			
			Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
			
			while (target.getType().equals(Material.AIR)) 
			{
				
				target = event.getPlayer().getWorld().getBlockAt(target.getLocation().subtract(new Location(event.getPlayer().getWorld(), 0.5, 1, 0.5))) ;
				
			}
			
			Location newlocation = target.getLocation().add(new Location(event.getPlayer().getWorld(), 0.5, 1, 0.5)) ;
			newlocation.setYaw(YAW);
			newlocation.setPitch(PITCH);
			
			//Location newlocation is a defined variable that we are using to store a player float (yaw/pitch), and then plugging this information into the teleport.
			
			event.getPlayer().teleport(newlocation);
			
			new BukkitRunnable()
			{
				 @Override
				  public void run()
				  {
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1);
				  }
			}.runTaskLater(Zenith.getInstance(), 10);
			
			return true;
			
		}
		
		float YAW = event.getPlayer().getLocation().getYaw() ;
		float PITCH = event.getPlayer().getLocation().getPitch() ;
		
		float entityYAW = targetEntity.getLocation().getYaw() ;
		float entityPITCH = targetEntity.getLocation().getPitch() ;
		
		Location playerLocation = event.getPlayer().getLocation();
		Location entityLocation = targetEntity.getLocation();

		entityLocation.setPitch(PITCH);
		entityLocation.setYaw(YAW);
		playerLocation.setPitch(entityPITCH);
		playerLocation.setYaw(entityYAW);
		
		event.getPlayer().teleport(entityLocation);
		targetEntity.teleport(playerLocation);
		
		new BukkitRunnable()
		{
			 @Override
			  public void run()
			  {
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1);
			  }
		}.runTaskLater(Zenith.getInstance(), 10);
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
