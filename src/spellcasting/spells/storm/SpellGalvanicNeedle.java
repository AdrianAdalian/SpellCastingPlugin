package spellcasting.spells.storm;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_GalvanicNeedle;

public class SpellGalvanicNeedle extends BaseSpell
{

	public SpellGalvanicNeedle()
	{
		super(Material.AMETHYST_SHARD, "§r§e§ko§r§e§lRelic: §r§fGalvanic Needle§r§e§ko§r", 10, true, "§r§fElement: §r§dStorm§r§f.","§r§fFire an electrified crystal shard that acts like a lightning rod.","§r§fDeals 1/2 heart of §r§cdamage §r§ffrom crystal strike,","§r§fThen summons a bolt of lightning at target.","§r§fMana cost: 10 §r§9mana§r§f.");
	}
	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_AMETHYST_BLOCK_FALL, SoundCategory.MASTER, 1, 1);
		
		new SpellProjectile_GalvanicNeedle().launch(event.getPlayer());
		return true;
	}
}