package spellcasting.spells.water;

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

import spellcasting.spells.BaseSpell;

public class SpellTidalWave extends BaseSpell
{

	public SpellTidalWave()
	{
		super(Material.BLUE_DYE, "§r§7§ko§r§7§lSpell: §r§fTidal Wave§r§7§ko§r", 15, true, "§r§fElement: §r§9Water§r§f.","§r§fConduct a current of water,","§r§fdamaging and slowing all within range.","§r§fDeals 3 hearts of §r§cdamage§r§f.","§r§fDuration: 10 seconds.","§r§fRange: 15 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
	
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		for (Entity target : event.getPlayer().getNearbyEntities(15, 15, 15)) 
		{
			
			if (target instanceof LivingEntity) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
				((Damageable) target).damage(6, event.getPlayer());
				((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
				return true;
			}
		}
		return false;
	}
}
