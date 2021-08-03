package spellcasting.registered.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.yukiemeralis.blogspot.modules.zenithgui.base.DynamicGui;

import spellcasting.spells.storm.SpellBlink;
import spellcasting.spells.storm.SpellGaleForce;
import spellcasting.spells.storm.SpellGust;
import spellcasting.spells.storm.SpellHealingCurrent;
import spellcasting.spells.storm.SpellLightningStorm;
import spellcasting.spells.storm.SpellSmite;
import spellcasting.spells.storm.SpellStaticCharge;
import spellcasting.spells.storm.SpellTailWind;
import spellcasting.spells.storm.SpellTeleport;
import spellcasting.spells.storm.SpellThunderStrike;
import spellcasting.spells.storm.SpellVaporize;
import spellcasting.spells.storm.SpellWildBolt;

public class SpellGUI_Storm extends DynamicGui
{

	public SpellGUI_Storm()
	{
		super(54, "Book of Storm", null, InventoryAction.PICKUP_ALL,InventoryAction.PICKUP_HALF);
	}

	@Override
	public void init()
	{
		
		paint();
		
		addComponent(19, new SpellTailWind());
		addComponent(20, new SpellStaticCharge());
		addComponent(21, new SpellHealingCurrent());
		addComponent(22, new SpellBlink());
		addComponent(23, new SpellTeleport());
		addComponent(25, new SpellWildBolt());
		addComponent(28, new SpellSmite());
		addComponent(29, new SpellThunderStrike());
		addComponent(30, new SpellVaporize());
		addComponent(31, new SpellGust());
		addComponent(32, new SpellGaleForce());
		addComponent(34, new SpellLightningStorm());
		
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
