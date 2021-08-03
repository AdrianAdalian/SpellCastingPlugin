package spellcasting.spells.water;

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

public class SpellGills extends BaseSpell
{

	public SpellGills()
	{
		super(Material.LIGHT_BLUE_DYE, "§r§7§ko§r§7§lSpell: §r§fGills§r§7§ko§r", 15, false, "§r§fElement: §r§9Water§r§f.","§r§fGrants the caster temporary water breathing.","§r§fDuration: 20 seconds.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_ACTIVATE, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 400, 0));
		
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_DEACTIVATE, SoundCategory.MASTER, 1, 1);
		   }
		 }.runTaskLater(Zenith.getInstance(), 405);
			return true;
	}	
}
