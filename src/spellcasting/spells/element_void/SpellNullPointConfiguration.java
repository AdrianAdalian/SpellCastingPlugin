package spellcasting.spells.element_void;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellNullPointConfiguration extends BaseSpell
{

	public SpellNullPointConfiguration()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fNullPoint Configuration§r§f§ko§r", 15, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fA book containing the power to reconfigure all matter.","§r§fSummon a portable crafting bench at will.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1); 
		
		event.getPlayer().openInventory(event.getPlayer().openWorkbench(event.getPlayer().getLocation(), true));
		
		return true;
	}
}
