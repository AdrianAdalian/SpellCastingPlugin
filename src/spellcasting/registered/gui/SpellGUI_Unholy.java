package spellcasting.registered.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.yukiemeralis.blogspot.modules.zenithgui.base.DynamicGui;

import spellcasting.spells.unholy.SpellBlindingDust;
import spellcasting.spells.unholy.SpellDamagingForce;
import spellcasting.spells.unholy.SpellDebilitate;
import spellcasting.spells.unholy.SpellDecompose;
import spellcasting.spells.unholy.SpellDefile;
import spellcasting.spells.unholy.SpellDemonSight;
import spellcasting.spells.unholy.SpellDemonicReflexes;
import spellcasting.spells.unholy.SpellLifeSteal;
import spellcasting.spells.unholy.SpellLightShift;
import spellcasting.spells.unholy.SpellRaiseDead;
import spellcasting.spells.unholy.SpellReapSouls;
import spellcasting.spells.unholy.SpellStormSurge;

public class SpellGUI_Unholy extends DynamicGui
{
	public SpellGUI_Unholy()
	{
		super(54, "Book of Unholy", null, InventoryAction.PICKUP_ALL,InventoryAction.PICKUP_HALF);
	}

	@Override
	public void init()
	{
		
		paint();
		
		addComponent(19, new SpellDemonSight());
		addComponent(20, new SpellLightShift());
		addComponent(21, new SpellDemonicReflexes());
		addComponent(22, new SpellDebilitate());
		addComponent(23, new SpellRaiseDead());
		addComponent(25, new SpellDamagingForce());
		addComponent(28, new SpellLifeSteal());
		addComponent(29, new SpellReapSouls());
		addComponent(30, new SpellDefile());
		addComponent(31, new SpellBlindingDust());
		addComponent(32, new SpellDecompose());
		addComponent(34, new SpellStormSurge());
		
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
