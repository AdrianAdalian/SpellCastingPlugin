package spellcasting.spells.storm;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellSmite extends BaseSpell 
{

	public SpellSmite()
	{
		super(Material.PURPLE_DYE, "§r§7§ko§r§7§lSpell: §r§fSmite§r§7§ko§r", 10, false, "§r§fElement: §r§dStorm§r§f.","§r§fSummons a small bolt of lightning.","§r§fRange: 10 meters.","§r§fDeals 2.5 hearts of §r§cdamage§r§f.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		int TARGETRANGE = 10 ;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		if (target.getType().equals(Material.AIR))
		{
			return false;			
		}
		event.getPlayer().getWorld().strikeLightning(target.getLocation()) ;
		return true;
	}
}
