package spellcasting.spells.geo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_Boulder;

public class SpellBoulder extends BaseSpell 
{

	public SpellBoulder()
	{
		super(Material.BROWN_DYE, "§r§7§ko§r§7§lSpell: §r§fBoulder§r§7§ko§r", 10, false, "§r§fElement: §r§6Geo§r§f.","§r§fHurl a large boulder that stuns upon impact.","§r§fDeals 3 hearts of §r§cdamage§r§f.","§r§fStun for 3 seconds.","§r§fRange: 20 meters.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SNOWBALL_THROW, SoundCategory.MASTER, 1, 1);
		
		new SpellProjectile_Boulder().launch(event.getPlayer());
		return true; 
	}
}
