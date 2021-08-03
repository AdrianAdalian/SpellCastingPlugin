package spellcasting.spells.geo;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import spellcasting.spells.BaseSpell;

public class SpellPoisonGas extends BaseSpell
{

	public SpellPoisonGas()
	{
		super(Material.SLIME_BALL, "§r§7§ko§r§7§lSpell: §r§fPoison Gas§r§7§ko§r", 15, true, "§r§fElement: §r§6Geo§r§f.","§r§fEmits a burst of highly toxic fumes within a radius.","§r§fDeals 4 hearts of §r§cdamage§r§f over 5 seconds.","§r§fRange: 5 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		for (Entity target : event.getPlayer().getNearbyEntities(5, 5, 5)) 
		{
			if (target instanceof LivingEntity)
	    	{
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
	    		return true;
	    	}  
		}	
		return true;
	}
}
