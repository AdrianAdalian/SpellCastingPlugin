package spellcasting.spells.geo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellEarthquake extends BaseSpell
{
	
	public SpellEarthquake()
	{
		super(Material.BROWN_DYE, "§r§7§ko§r§7§lSpell: §r§fEarthquake§r§7§ko§r", 20, true, "§r§fElement: §r§6Geo§r§f.","§r§fCause an earthquake that damages","§r§fand stuns all within the radius.","§r§fDeals 1 heart of §r§cdamage§r§f to all effected.","§r§fStun for 5 seconds.","§r§fRange: 15 meters.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		if (event.getPlayer().getNearbyEntities(15, 15, 15).size() == 0)
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(15, 15, 15))
		{
			
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_STONE_BREAK, SoundCategory.MASTER, 1, 1);
			
			target.setVelocity(target.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
			if (target instanceof Damageable)
			{
				((Damageable) target).damage(2, event.getPlayer());
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 99));
			}
		}
		return true; 
	}
}
