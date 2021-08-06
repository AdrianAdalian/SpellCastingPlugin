package spellcasting.spells.element_void;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellVoidPearl extends BaseSpell
{

	public SpellVoidPearl()
	{
		super(Material.ENDER_PEARL, "§r§7§ko§r§7§lSpell: §r§fVoid Pearl§r§7§ko§r", 15, true, "§r§fElement: §r§3§lVOID§r§f.","§r§fA pearl enchanted by the forces of the §r§3§lVOID§r§f.","§r§fSummon a portable storage unit at will.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, SoundCategory.MASTER, 1, 1);
		
		Inventory enderchest = event.getPlayer().getEnderChest();
		
		event.getPlayer().openInventory(enderchest);
		
		return true;
	}
}
