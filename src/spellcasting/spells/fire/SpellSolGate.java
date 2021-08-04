package spellcasting.spells.fire;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellSolGate extends BaseSpell
{

	public SpellSolGate()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fSolGate§r§f§ko§r", 30, false, "§r§fElement: §r§cFire§r§f.", "§r§fSummons a void gate from the orbiting sun.","§r§fThe gate summons three balls of fire onto a target.","§r§fRange: 10 meters.","§r§fMana cost: 30 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
			
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		Entity target = getNearestEntityInSight(event.getPlayer(), 10);
		
		Vector v = new Vector(0,-5,0);
		
		if (target == null) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		Location newlocation = target.getLocation().add(new Location(event.getPlayer().getWorld(), 0, 15, 0)) ;
		newlocation.add(0, 15, 0);
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		Fireball fireball = target.getWorld().spawn(newlocation, Fireball.class);
		fireball.setShooter(event.getPlayer());
		fireball.setDirection(v);
		
		new BukkitRunnable()
		{
		  @Override
		  public void run()
		  {
			  	event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
				Fireball fireball = target.getWorld().spawn(newlocation, Fireball.class);
				fireball.setShooter(event.getPlayer());
				fireball.setDirection(v);
		  }
		}.runTaskLater(Zenith.getInstance(), 20);
		
		new BukkitRunnable()
		{
		  @Override
		  public void run()
		  {
			  	event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
				Fireball fireball = target.getWorld().spawn(newlocation, Fireball.class);
				fireball.setShooter(event.getPlayer());
				fireball.setDirection(v);
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
