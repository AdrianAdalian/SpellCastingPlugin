package spellcasting;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import com.yukiemeralis.blogspot.zenith.utils.ItemUtils;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.nightside.mana.SpellManaInterface;
import spellcasting.registered.gui.SpellGUI_Fire;
import spellcasting.registered.gui.SpellGUI_Geo;
import spellcasting.registered.gui.SpellGUI_Holy;
import spellcasting.registered.gui.SpellGUI_Storm;
import spellcasting.registered.gui.SpellGUI_Unholy;
import spellcasting.registered.gui.SpellGUI_Void;
import spellcasting.registered.gui.SpellGUI_Water;

public class CastingListener implements Listener
{
	@EventHandler
	public void onCast(PlayerInteractEvent event) 
	{
		ItemStack held;
		held = event.getPlayer().getInventory().getItem(EquipmentSlot.HAND) ;
		
		if (event.getHand().equals(EquipmentSlot.OFF_HAND))
		{
			return;
		}
		
		if(held==null || held.getType().equals(Material.AIR))
		{
			return ;
		}
		if(ItemUtils.hasNamespacedKey(held, "spellname")) 
		{
			event.setCancelled(true);
			
			PrintUtils.log(event.getAction().toString());
			
			String spell = ItemUtils.readFromNamespacedKey(held, "spellname");
			
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()>=CastListener.spell_registry.get(spell).getManaCost()) 
			{
				if(CastListener.spell_registry.get(spell).cast(event)) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - CastListener.spell_registry.get(spell).getManaCost());
					SpellManaInterface.updateScoreBoard(event.getPlayer());
					return;		
				}
				return;
			}
			
			PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
			
			return;
		}
		
		if (ItemUtils.hasNamespacedKey(held, "SpellBookStormID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Storm gui = new SpellGUI_Storm();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookFireID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Fire gui = new SpellGUI_Fire();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookUnholyID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Unholy gui = new SpellGUI_Unholy();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookGeoID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Geo gui = new SpellGUI_Geo();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookHolyID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Holy gui = new SpellGUI_Holy();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookWaterID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Water gui = new SpellGUI_Water();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookVoidID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Void gui = new SpellGUI_Void();
			gui.init();
			gui.display(event.getPlayer());
		}
	}
}
