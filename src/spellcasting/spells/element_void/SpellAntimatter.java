package spellcasting.spells.element_void;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellAntimatter extends BaseSpell
{

	public SpellAntimatter()
	{
		super(Material.ENDER_PEARL, "§r§7§ko§r§7§lSpell: §r§fAntimatter§r§7§ko§r", 25, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fSummon a small concentration of antimatter","§r§fthat causes an explosion at the target block.","§r§fRange: 30 meters.","§r§fMana cost: 25 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage("Invalid Cast Method.");
			return false;
		}
		
		int TARGETRANGE = 30 ;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		if (target.getType().equals(Material.AIR)) 
		{
			PrintUtils.sendMessage("Invalid Target.");
			return false;
		}
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, SoundCategory.MASTER, 1, 1);
		target.getWorld().createExplosion(target.getLocation(), 5);
		
		return true;
	}

}
