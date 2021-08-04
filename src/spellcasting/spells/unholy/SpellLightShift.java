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
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellLightShift extends BaseSpell
{

	public SpellLightShift()
	{
		super(Material.GRAY_DYE, "§r§7§ko§r§7§lSpell: §r§fLight Shift§r§7§ko§r", 15, false, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fBoosts caster's evasiveness against surrounding entities.","§r§fDuration: 15 seconds.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false; 
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 300, 0));
		event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 300, 1));
			
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 305);
		return true;
	}
}
