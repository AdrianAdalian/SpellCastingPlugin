package spellcasting;

import org.bukkit.Material;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import com.yukiemeralis.blogspot.zenith.utils.ItemUtils;

public class InventoryUtilities 
{
	public static int searchForSpellBook(InventoryView view,String bookname) 
	{
		for (int i = 54; i < 90; i++) 
		{
			ItemStack stack = view.getItem(i);
			if (stack == null) 
			{
				continue;
			}
			if (stack.getType().equals(Material.AIR)) 
			{
				continue;
			}
			if (ItemUtils.hasNamespacedKey(stack, bookname))
			{
				return i;
			}
		}
			return -999;
	}
}
