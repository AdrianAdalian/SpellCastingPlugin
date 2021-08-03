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

public class SpellInscribeLuck extends BaseSpell
{

	public SpellInscribeLuck()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fInscribe Luck§r§f§ko§r", 15, false, "§r§fElement: §r§6Geo§r§f.","§r§fUsing the forces of §r§6Geo§r§f,","§r§ftemporarily boost caster's luck stat.","§r§fDuration: 15 seconds.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 300, 0));
		 
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		   }
		 }.runTaskLater(Zenith.getInstance(), 305);
		 return true;
	}
}
