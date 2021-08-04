package spellcasting.spells.holy;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellExpandingForce extends BaseSpell
{

	public SpellExpandingForce()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fExpanding Force§r§f§ko§r", 5, false, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fEmits a radial force.","§r§fRange: 5 meters.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		for (Entity target : event.getPlayer().getNearbyEntities(5, 5, 5))
		{
			
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			
			target.setVelocity(target.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
			return true;
		}
		return false;
	}
}
