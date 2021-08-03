package spellcasting.registered.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;

import com.yukiemeralis.blogspot.modules.zenithgui.base.DynamicGui;

import spellcasting.spells.holy.SpellAccolades;
import spellcasting.spells.holy.SpellAngelicFlight;
import spellcasting.spells.holy.SpellBarrier;
import spellcasting.spells.holy.SpellExpandingForce;
import spellcasting.spells.holy.SpellExtricate;
import spellcasting.spells.holy.SpellGuardianAngel;
import spellcasting.spells.holy.SpellJudgement;
import spellcasting.spells.holy.SpellNosferatu;
import spellcasting.spells.holy.SpellRadiance;
import spellcasting.spells.holy.SpellRejuvenation;
import spellcasting.spells.holy.SpellRepentance;
import spellcasting.spells.holy.SpellSatiate;

public class SpellGUI_Holy extends DynamicGui
{
	public SpellGUI_Holy()
	{
		super(54, "Book of Holy", null, InventoryAction.PICKUP_ALL,InventoryAction.PICKUP_HALF);
	}

	@Override
	public void init()
	{
		
		paint();
		
		addComponent(19, new SpellNosferatu());
		addComponent(20, new SpellSatiate());
		addComponent(21, new SpellExtricate());
		addComponent(22, new SpellAccolades());
		addComponent(23, new SpellJudgement());
		addComponent(25, new SpellExpandingForce());
		addComponent(28, new SpellBarrier());
		addComponent(29, new SpellRadiance());
		addComponent(30, new SpellRejuvenation());
		addComponent(31, new SpellRepentance());
		addComponent(32, new SpellAngelicFlight());
		addComponent(34, new SpellGuardianAngel());
		
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
