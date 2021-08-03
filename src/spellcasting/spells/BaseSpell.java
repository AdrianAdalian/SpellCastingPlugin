package spellcasting.spells;

import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.yukiemeralis.blogspot.modules.zenithgui.GuiComponent;
import com.yukiemeralis.blogspot.modules.zenithgui.GuiItemStack;
import com.yukiemeralis.blogspot.zenith.utils.ItemUtils;

import spellcasting.InventoryUtilities;

public abstract class BaseSpell implements GuiComponent//abstract: The parts of an object; it defines the behavior that all things which extend this must have.
{
	
	protected GuiItemStack Icon;
	protected String displayName;
	protected String[] displayLore;
	protected Material material;
	protected boolean glow = false;
	
	public BaseSpell(Material material, String displayName, int manaCost, boolean glow, String...displayLore) 
	{
		this.displayLore = displayLore;
		this.displayName = displayName;
		this.material = material;
		this.glow = glow;
		this.manaCost = manaCost;
	}
	
	int manaCost;
	public int getManaCost() 
	{
		return manaCost;
	}
	
	public GuiItemStack getIcon() 
	{
		return Icon;
	}
	public abstract boolean cast(PlayerInteractEvent event);
	@Override
	public void onIconInteract(InventoryClickEvent event)
	{
		if (toIcon() == null)
		{
			Icon = this.toIcon();
		}
		Icon.onIconInteract(event);
	}
	@Override
	public GuiItemStack toIcon() 
	{
		if (this.Icon != null)
		    return this.Icon;

		this.Icon = new GuiItemStack(material)
		{
		    @Override
		    public void onIconInteract(InventoryClickEvent event)	
		    {
		    	ItemStack clone = this.clone();
		    	ItemUtils.saveToNamespacedKey(clone, "UUID", UUID.randomUUID().toString());		
		    
		    	if (event.getView().getTitle().equals("Book of Storm")) 
		    	{
		    		int slot = InventoryUtilities.searchForSpellBook(event.getView(), "SpellBookStormID");
		    		ItemUtils.saveToNamespacedKey(clone,"BookName","Book of Storm");
		    		event.getView().setItem(slot, clone);
		    	}
		    	if (event.getView().getTitle().equals("Book of Fire")) 
		    	{
		    		int slot = InventoryUtilities.searchForSpellBook(event.getView(), "SpellBookFireID");
		    		ItemUtils.saveToNamespacedKey(clone,"BookName","Book of Fire");
		    		event.getView().setItem(slot, clone);
		    	}
		    	if (event.getView().getTitle().equals("Book of Geo")) 
		    	{
		    		int slot = InventoryUtilities.searchForSpellBook(event.getView(), "SpellBookGeoID");
		    		ItemUtils.saveToNamespacedKey(clone,"BookName","Book of Geo");
		    		event.getView().setItem(slot, clone);
		    	}
		    	if (event.getView().getTitle().equals("Book of Unholy")) 
		    	{
		    		int slot = InventoryUtilities.searchForSpellBook(event.getView(), "SpellBookUnholyID");
		    		ItemUtils.saveToNamespacedKey(clone,"BookName","Book of Unholy");
		    		event.getView().setItem(slot, clone);
		    	}
		    	if (event.getView().getTitle().equals("Book of Holy")) 
		    	{
		    		int slot = InventoryUtilities.searchForSpellBook(event.getView(), "SpellBookHolyID");
		    		ItemUtils.saveToNamespacedKey(clone,"BookName","Book of Holy");
		    		event.getView().setItem(slot, clone);
		    	}
		    	if (event.getView().getTitle().equals("Book of Water")) 
		    	{
		    		int slot = InventoryUtilities.searchForSpellBook(event.getView(), "SpellBookWaterID");
		    		ItemUtils.saveToNamespacedKey(clone,"BookName","Book of Water");
		    		event.getView().setItem(slot, clone);
		    	}
		    	if (event.getView().getTitle().equals("Book of Void")) 
		    	{
		    		int slot = InventoryUtilities.searchForSpellBook(event.getView(), "SpellBookVoidID");
		    		ItemUtils.saveToNamespacedKey(clone,"BookName","Book of Void");
		    		event.getView().setItem(slot, clone);
		    	}
		    	event.getWhoClicked().closeInventory();
		    }
		};

		ItemUtils.applyName(this.Icon, displayName);
		ItemUtils.applyLore(this.Icon, displayLore);
		ItemUtils.saveToNamespacedKey(this.Icon, "spellname", this.getClass().getSimpleName());
		
		if (glow == true)
		{
			ItemMeta meta = this.Icon.getItemMeta();
			meta.addEnchant(Enchantment.DURABILITY, 0, glow);
			meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
			this.Icon.setItemMeta(meta);
		}
		return this.Icon;
	}
}
