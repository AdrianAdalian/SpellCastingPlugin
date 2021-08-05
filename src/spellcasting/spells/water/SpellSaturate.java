package spellcasting.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellSaturate extends BaseSpell
{

	public SpellSaturate()
	{
		super(Material.LAPIS_LAZULI, "§r§7§ko§r§7§lSpell: §r§fSaturate§r§7§ko§r", 5, true, "§r§fElement: §r§9Water§r§f.","§r§fSaturate a nearby block, turning it into water.","§r§fRange: 5 meters.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}	
		
		int TARGETRANGE = 5;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		if (target == null) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
		
		target.getRelative(BlockFace.UP).setType(Material.WATER);
		return true;
	}
}
