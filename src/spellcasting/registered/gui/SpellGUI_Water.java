package spellcasting.registered.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.yukiemeralis.blogspot.modules.zenithgui.base.DynamicGui;

import spellcasting.spells.water.SpellCrystalize;
import spellcasting.spells.water.SpellFishScales;
import spellcasting.spells.water.SpellGills;
import spellcasting.spells.water.SpellManaBurn;
import spellcasting.spells.water.SpellPoseidonsGift;
import spellcasting.spells.water.SpellRagingCurrent;
import spellcasting.spells.water.SpellRipTide;
import spellcasting.spells.water.SpellSaturate;
import spellcasting.spells.water.SpellSuffocate;
import spellcasting.spells.water.SpellTidalForce;
import spellcasting.spells.water.SpellTidalWave;
import spellcasting.spells.water.SpellWaterLash;

public class SpellGUI_Water extends DynamicGui
{
	public SpellGUI_Water()
	{
		super(54, "Book of Water", null, InventoryAction.PICKUP_ALL,InventoryAction.PICKUP_HALF);
	}

	@Override
	public void init()
	{
		
		paint();
		
		addComponent(19, new SpellWaterLash());
		addComponent(20, new SpellTidalWave());
		addComponent(21, new SpellSuffocate());
		addComponent(22, new SpellManaBurn());
		addComponent(23, new SpellFishScales());
		addComponent(25, new SpellPoseidonsGift());
		addComponent(28, new SpellRipTide());
		addComponent(29, new SpellTidalForce());
		addComponent(30, new SpellRagingCurrent());
		addComponent(31, new SpellGills());
		addComponent(32, new SpellSaturate());
		addComponent(34, new SpellCrystalize());
		
		paintComponents();
		
	}
	
	@Override
	@EventHandler
	public void onInteract(InventoryClickEvent event)
	{
		
		if (!isEventApplicable(event, true))
		    return;

		DynamicGui gui = DynamicGui.getOpenedGuis().get(event.getWhoClicked());
		if (gui.getComponents().containsKey(event.getRawSlot()))
		{
		    gui.getComponents().get(event.getRawSlot()).onIconInteract(event);
		    return;
		}
	}
}
