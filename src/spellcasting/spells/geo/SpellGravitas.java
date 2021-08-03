package spellcasting.spells.geo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellGravitas extends BaseSpell
{

	public SpellGravitas()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fGravitas§r§f§ko§r", 15, false, "§r§fElement: §r§6Geo§r§f.","§r§fTemporarily resist the forces of gravity.","§r§fDuration: 10 seconds.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		//PrintUtils.log(event.getAction().name() , InfoType.INFO) ; 
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 200, 0));
		
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
		   }
		 }.runTaskLater(Zenith.getInstance(), 205);
		 return true;
	}	
}
