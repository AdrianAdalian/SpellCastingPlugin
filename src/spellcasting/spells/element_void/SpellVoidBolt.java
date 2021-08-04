package spellcasting.spells.element_void;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_VoidBolt;

public class SpellVoidBolt extends BaseSpell
{

	public SpellVoidBolt()
	{
		super(Material.ENDER_PEARL, "§r§7§ko§r§7§lSpell: §r§fVoid Bolt§r§7§ko§r", 10, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fExpell a bolt of §r§3§lVOID§r§f energy.","§r§fThe receiver is briefly weakened,","§r§fslowed, and fatigued.","§r§fDuration: 10 seconds.","§r§fRange: 20 meters.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			PrintUtils.sendMessage("Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SHULKER_SHOOT, SoundCategory.MASTER, 1, 1);
		
		new SpellProjectile_VoidBolt().launch(event.getPlayer());
		
		return true;
	}

}
