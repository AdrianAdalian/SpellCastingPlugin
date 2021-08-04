package spellcasting.spells.element_void;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellMatterReversal extends BaseSpell
{

	public SpellMatterReversal()
	{
		super(Material.ENDER_PEARL, "§r§7§ko§r§7§lSpell: §r§fMatter Reversal§r§7§ko§r", 5, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fExpell a burst of §r§3§lVOID§r§f energy","§r§fstrong enough to distort matter.","§r§fCause any target block to decompose,","§r§flaying waste any natural materials.","§r§fRange: 1 meter.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			PrintUtils.sendMessage("Invalid Cast Method.");
			return false;
		}
		
		int TARGETRANGE = 1 ;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		if (target.getType().equals(Material.AIR))
		{
			PrintUtils.sendMessage("Invalid Target.");
			return false;			
		}
		if (target.getType().equals(Material.BEDROCK)) 
		{
			PrintUtils.sendMessage(event.getPlayer(), "Invalid Target.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_FOX_TELEPORT, SoundCategory.MASTER, 1, 1); 
		target.breakNaturally();
		
		return true;
	}
}
