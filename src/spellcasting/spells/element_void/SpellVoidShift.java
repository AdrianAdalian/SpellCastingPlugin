package spellcasting.spells.element_void;

import org.bukkit.GameMode;
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

public class SpellVoidShift extends BaseSpell
{

	public SpellVoidShift()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fVoid Shift§r§f§ko§r", 30, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fA forbidden tome that allows the caster to temporarily","§r§fshift into the void, free of physical restraints.","§r§fDuration: 15 seconds.","§r§fMana cost: 30 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}

		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
		event.getPlayer().setGameMode(GameMode.SPECTATOR);
		
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 30, 0));
			}
		}.runTaskLater(Zenith.getInstance(), 240);	
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
				event.getPlayer().setGameMode(GameMode.SURVIVAL);
			}
		}.runTaskLater(Zenith.getInstance(), 300);	
		
		return true;
	}
}
