package spellcasting.spells.storm;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellLightningStorm extends BaseSpell
{

	public SpellLightningStorm()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fLightningStorm§r§f§ko§r", 20, false, "§r§fElement: §r§dStorm§r§f.","§r§fSummons lightning onto all enemies within a small radius.","§r§fRange: 15 meters.","§r§fDeals 2.5 hearts of §r§cdamage §r§fper lightning bolt.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		for (Entity target : event.getPlayer().getNearbyEntities(15, 15, 15))
		{
			
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
			
			event.getPlayer().getWorld().strikeLightning(target.getLocation());
			return true;
		}
		return false;
	}
}
