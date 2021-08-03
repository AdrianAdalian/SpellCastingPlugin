package spellcasting.registered.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.yukiemeralis.blogspot.modules.zenithgui.base.DynamicGui;

import spellcasting.spells.geo.SpellBoulder;
import spellcasting.spells.geo.SpellDracoMorph;
import spellcasting.spells.geo.SpellEarthquake;
import spellcasting.spells.geo.SpellGeoMorph;
import spellcasting.spells.geo.SpellGravitas;
import spellcasting.spells.geo.SpellInscribeLuck;
import spellcasting.spells.geo.SpellMageMorph;
import spellcasting.spells.geo.SpellMetalMorph;
import spellcasting.spells.geo.SpellPebbles;
import spellcasting.spells.geo.SpellPoisonDart;
import spellcasting.spells.geo.SpellPoisonGas;
import spellcasting.spells.geo.SpellTransmute;

public class SpellGUI_Geo extends DynamicGui
{
	public SpellGUI_Geo()
	{
		super(54, "Book of Geo", null, InventoryAction.PICKUP_ALL,InventoryAction.PICKUP_HALF);
	}

	@Override
	public void init()
	{
		
		paint();
		
		addComponent(19, new SpellPebbles());
		addComponent(20, new SpellBoulder());
		addComponent(21, new SpellEarthquake());
		addComponent(22, new SpellPoisonDart());
		addComponent(23, new SpellPoisonGas());
		addComponent(25, new SpellGravitas());
		addComponent(28, new SpellGeoMorph());
		addComponent(29, new SpellMetalMorph());
		addComponent(30, new SpellMageMorph());
		addComponent(31, new SpellDracoMorph());
		addComponent(32, new SpellTransmute());
		addComponent(34, new SpellInscribeLuck());
		
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
