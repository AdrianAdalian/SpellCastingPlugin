package spellcasting.spells.element_void;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellMendingVoidPrecept extends BaseSpell
{

	public SpellMendingVoidPrecept()
	{
		super(Material.PAPER, "§r§7§ko§r§7§lSpell: §r§fLevitate§r§7§ko§r", 15, true, "");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		Location loc = event.getPlayer().getLocation();
		
		int X = loc.getBlockX() - 1;
		int Z = loc.getBlockZ() - 1;
		
		int playerY = event.getPlayer().getLocation().getBlockY();
		
		for (int i = X ; i <= (X + 3) ; i++) 
		{
			for (int j = Z ; i <= (Z +3) ; j++) 
			{
				int y = event.getPlayer().getWorld().getHighestBlockYAt(i, j);
				if (y == playerY || y == (playerY + 1) || y == (playerY - 1))
				{
					event.getPlayer().getWorld().getBlockAt(i, y, j).setType(Material.ANVIL);
					Bukkit.createInventory(event.getPlayer(), InventoryType.ANVIL);
				}
			}
		}
		
		
		return false;
	}

}
