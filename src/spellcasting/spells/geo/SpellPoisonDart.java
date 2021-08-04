package spellcasting.spells.geo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_PoisonDart;

public class SpellPoisonDart extends BaseSpell
{

	public SpellPoisonDart()
	{
		super(Material.ARROW, "§r§7§ko§r§7§lSpell: §r§fPoison Dart§r§7§ko§r", 10, false, "§r§fElement: §r§6Geo§r§f.","§r§fLaunch a blob of toxic liquid that poisons what it hits.","§r§fDeals 1 heart of immediate §r§cdamage§r§f.","§r§fThen, 4 hearts of §r§cdamage§r§f over 10 seconds.","§r§fRange: 10 meters.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
		
		new SpellProjectile_PoisonDart().launch(event.getPlayer());
		
		return true;
	}
}
