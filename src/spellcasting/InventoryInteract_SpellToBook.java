package spellcasting;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.yukiemeralis.blogspot.zenith.utils.ItemUtils;

import spellcasting.spells.recipe.SpellRecipe_BookOfFire;
import spellcasting.spells.recipe.SpellRecipe_BookOfGeo;
import spellcasting.spells.recipe.SpellRecipe_BookOfHoly;
import spellcasting.spells.recipe.SpellRecipe_BookOfStorm;
import spellcasting.spells.recipe.SpellRecipe_BookOfUnholy;
import spellcasting.spells.recipe.SpellRecipe_BookOfVoid;
import spellcasting.spells.recipe.SpellRecipe_BookOfWater;

public class InventoryInteract_SpellToBook implements Listener
{
	
	@EventHandler
	public void onInteract(InventoryClickEvent event)
	{
		
		ItemStack stack = event.getView().getItem(event.getRawSlot());
		
		if (stack == null || stack.getType().equals(Material.AIR)) 
		{
			return;
		}
		
		if(ItemUtils.hasNamespacedKey(stack,"BookName"))
		{
			
			String bookName = ItemUtils.readFromNamespacedKey(stack,"BookName");
			event.setCancelled(true);
			
			switch(bookName)
			{
				case "Book of Storm":
				{
					event.getView().setItem(event.getRawSlot(),SpellRecipe_BookOfStorm.getFinal_item().clone());	
					event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
					break;
				}
				case "Book of Fire":
				{
					event.getView().setItem(event.getRawSlot(),SpellRecipe_BookOfFire.getFinal_item());
					event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
					break;
				}
				case "Book of Geo":
				{
					event.getView().setItem(event.getRawSlot(),SpellRecipe_BookOfGeo.getFinal_item());
					event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
					break;
				}
				case "Book of Holy":
				{
					event.getView().setItem(event.getRawSlot(),SpellRecipe_BookOfHoly.getFinal_item());
					event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
					break;
				}
				case "Book of Unholy":
				{
					event.getView().setItem(event.getRawSlot(),SpellRecipe_BookOfUnholy.getFinal_item());
					event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
					break;
				}
				case "Book of Water":
				{
					event.getView().setItem(event.getRawSlot(),SpellRecipe_BookOfWater.getFinal_item());
					event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
					break;
				}
				case "Book of Void":
				{
					event.getView().setItem(event.getRawSlot(),SpellRecipe_BookOfVoid.getFinal_item());
					event.getWhoClicked().setItemOnCursor(new ItemStack(Material.AIR));
					break;
				}
			}
		}
	}
}
