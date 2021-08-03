package spellcasting.spells.unholy;

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

public class SpellDemonicReflexes extends BaseSpell 
{

	public SpellDemonicReflexes()
	{
		super(Material.GRAY_DYE, "§r§7§ko§r§7§lSpell: §r§fDemonic Reflexes§r§7§ko§r", 15, false, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fBoost caster's ability to vertically scale objects.","§r§fAlso slightly boosts movement speed.","§r§fDuration: 20 seconds.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false; 
		}
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 2));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
			
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 205);
		return true;
	}
}
