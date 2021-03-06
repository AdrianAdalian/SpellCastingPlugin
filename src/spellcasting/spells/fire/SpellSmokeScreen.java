package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.spells.BaseSpell;

public class SpellSmokeScreen extends BaseSpell
{

	public SpellSmokeScreen()
	{
		super(Material.GUNPOWDER, "§r§7§ko§r§7§lSpell: §r§fSmokeScreen§r§7§ko§r", 15, false, "§r§fElement: §r§cFire§r§f.","§r§fEmit a burst of ash that blinds","§r§fand slows all within radius.","§r§fDuration: 15 seconds.","§r§fRange: 7 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, null);
		
		if (event.getPlayer().getNearbyEntities(7, 7, 7).size() == 0)
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(7, 7, 7)) 
		{
			if (target instanceof LivingEntity)
	    	{	
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 0));
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 0));		
	    	}  
		}	
		return true; 
	}
}
