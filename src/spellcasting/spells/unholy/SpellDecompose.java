package spellcasting.spells.unholy;

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

import spellcasting.spells.BaseSpell;

public class SpellDecompose extends BaseSpell
{

	public SpellDecompose()
	{
		super(Material.BONE, "§r§7§ko§r§7§lSpell: §r§fDecompose§r§7§ko§r", 15, true, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fBegin to decompose any target within a small radius.","§r§fThe target is slowed as a result of acute necrosis.","§r§4Wither §r§f5 hearts over 10 seconds.","§r§fRange: 5 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		Entity target = getNearestEntityInSight(event.getPlayer(), 5);
		if ((target == null)) 
		{
			return false;
		}
		if ((target instanceof LivingEntity)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 1));
			((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
			return true;
		}
		if ((target instanceof Player)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 200, 1));
			((Player) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
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
