package spellcasting.registered.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.yukiemeralis.blogspot.modules.zenithgui.base.DynamicGui;

import spellcasting.spells.element_void.SpellAccelerate;
import spellcasting.spells.element_void.SpellAntimatter;
import spellcasting.spells.element_void.SpellCataclysm;
import spellcasting.spells.element_void.SpellEtherContinuity;
import spellcasting.spells.element_void.SpellLevitate;
import spellcasting.spells.element_void.SpellMatterReversal;
import spellcasting.spells.element_void.SpellNullPointConfiguration;
import spellcasting.spells.element_void.SpellRiftPortalization;
import spellcasting.spells.element_void.SpellTelekinesis;
import spellcasting.spells.element_void.SpellVoidBolt;
import spellcasting.spells.element_void.SpellVoidPearl;
import spellcasting.spells.element_void.SpellVoidShift;

public class SpellGUI_Void extends DynamicGui
{
	public SpellGUI_Void()
	{
		super(54, "Book of Void", null, InventoryAction.PICKUP_ALL,InventoryAction.PICKUP_HALF);
	}

	@Override
	public void init()
	{
		
		paint();
		
		addComponent(19, new SpellVoidBolt());
		addComponent(20, new SpellAntimatter());
		addComponent(21, new SpellCataclysm());
		addComponent(22, new SpellAccelerate());
		addComponent(23, new SpellEtherContinuity());
		addComponent(25, new SpellVoidShift());
		addComponent(28, new SpellLevitate());
		addComponent(29, new SpellTelekinesis());
		addComponent(30, new SpellMatterReversal());
		addComponent(31, new SpellVoidPearl());
		addComponent(32, new SpellRiftPortalization());
		addComponent(34, new SpellNullPointConfiguration());
		
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
