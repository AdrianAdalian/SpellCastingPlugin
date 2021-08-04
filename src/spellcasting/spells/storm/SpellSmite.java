package spellcasting.spells.storm;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellSmite extends BaseSpell 
{

	public SpellSmite()
	{
		super(Material.PURPLE_DYE, "§r§7§ko§r§7§lSpell: §r§fSmite§r§7§ko§r", 5, false, "§r§fElement: §r§dStorm§r§f.","§r§fSummons a small bolt of lightning.","§r§fRange: 10 meters.","§r§fDeals 2.5 hearts of §r§cdamage§r§f.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		int TARGETRANGE = 10 ;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		if (target.getType().equals(Material.AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;			
		}
		event.getPlayer().getWorld().strikeLightning(target.getLocation()) ;
		return true;
	}
}
