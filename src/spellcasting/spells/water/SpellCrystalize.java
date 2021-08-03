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
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellCrystalize extends BaseSpell
{

	public SpellCrystalize()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fCrystalize§r§f§ko§r", 25, false, "§r§fElement: §r§9Water§r§f.","§r§fSpikes burst from the casters body crystalizing them","§r§fwhile briefly rendering them immobilized and impervious.","§r§fAny within close proximity are slowed, weakened and damaged.","§r§fThe effects of the blast also cause targets to glow.","§r§fAfter the caster thaws,","§r§fgrant increased movement speed for 5 seconds.","§r§fDeals 3 hearts of §r§cdamage§r§f.","§r§fDuration for caster: 10 seconds.","§r§fDuration for targets: 20 seconds.","§r§fRange: 5 meters.","§r§fMana cost: 25 §r§9mana§r§f.");
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
				((Damageable) target).damage(6, event.getPlayer());
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 2));
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 4));
	    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 400, 0));
	    	}  
		}	
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_GLASS_PLACE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_AMETHYST_BLOCK_PLACE, SoundCategory.MASTER, 1, 1);
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 99));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 200, 9));
		
		new BukkitRunnable()
		{
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_GLASS_BREAK, SoundCategory.MASTER, 1, 1);
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.MASTER, 1, 1);
			   event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 2));
		   }
		}.runTaskLater(Zenith.getInstance(), 205);
		new BukkitRunnable()
		{
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_DEACTIVATE, SoundCategory.MASTER, 1, 1);
		   }
		}.runTaskLater(Zenith.getInstance(), 310);
	return true;
	}
}
