package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellKindleFlame extends BaseSpell
{

	public SpellKindleFlame()
	{
		super(Material.BLAZE_POWDER, "�r�7�ko�r�7�lSpell: �r�fKindle Flame�r�7�ko�r", 5, false, "�r�fElement: �r�cFire�r�f.","�r�fIgnites the nearby target block on fire.","�r�fRange: 5 meters.","�r�fMana cost: 5 �r�9mana�r�f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
	
		if (!event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
		{
			return false;
		}
		
		int TARGETRANGE = 5;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, SoundCategory.MASTER, 1, 1);
		
		target.getRelative(BlockFace.UP).setType(Material.FIRE);
		return true; 
	}
}
