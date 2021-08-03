package spellcasting.registered.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.yukiemeralis.blogspot.modules.zenithgui.base.DynamicGui;

import spellcasting.spells.fire.SpellFireBall;
import spellcasting.spells.fire.SpellFlameAura;
import spellcasting.spells.fire.SpellFlamethrower;
import spellcasting.spells.fire.SpellHeatWave;
import spellcasting.spells.fire.SpellIgnite;
import spellcasting.spells.fire.SpellIgnitionDrive;
import spellcasting.spells.fire.SpellInsulationPowder;
import spellcasting.spells.fire.SpellKindleFlame;
import spellcasting.spells.fire.SpellMeteor;
import spellcasting.spells.fire.SpellOverclockProtocol;
import spellcasting.spells.fire.SpellSmokeScreen;
import spellcasting.spells.fire.SpellSolGate;

public class SpellGUI_Fire extends DynamicGui
{
	public SpellGUI_Fire()
	{
		super(54, "Book of Fire", null, InventoryAction.PICKUP_ALL,InventoryAction.PICKUP_HALF);
	}

	@Override
	public void init()
	{
		
		paint();
		
		addComponent(19, new SpellKindleFlame());
		addComponent(20, new SpellIgnite());
		addComponent(21, new SpellHeatWave());
		addComponent(22, new SpellIgnitionDrive());
		addComponent(23, new SpellOverclockProtocol());
		addComponent(25, new SpellFlameAura());
		addComponent(28, new SpellFireBall());
		addComponent(29, new SpellFlamethrower());
		addComponent(30, new SpellMeteor());
		addComponent(31, new SpellSmokeScreen());
		addComponent(32, new SpellInsulationPowder());
		addComponent(34, new SpellSolGate());
		
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
