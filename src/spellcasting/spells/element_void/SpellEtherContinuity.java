package spellcasting.spells.element_void;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.attribute.Attribute;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.nightside.mana.SpellManaInterface;
import spellcasting.spells.BaseSpell;

public class SpellEtherContinuity extends BaseSpell
{

	public SpellEtherContinuity()
	{
		super(Material.END_CRYSTAL, "§r§7§ko§r§7§lSpell: §r§fEther Continuity§r§7§ko§r", 0, false, "§r§fElement: §r§3§lVOID§r§f.","§r§fA crystal formed from pure §r§3§lVOID§r§f energy.","§r§fThis spell's effect differ from time of day.","§r§fDuring the §r§6Day§r§f, channel mana into health.","§r§fDuring the §r§7Night§r§f, channel health into mana.","§r§fIf §r§7Night§r§f:","§r§fTake 3 hearts of §r§cdamage§r§f.","§r§fRestore 75 §r§9mana§r§f.","§r§fIf §r§6Day§r§f:","§r§aHeal§r§f 5 hearts.","§r§fMana cost: 25 §r§9mana§r§f.");
		
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage("Invalid Cast Method.");
			return false;
		}
		
		long time = Bukkit.getWorlds().get(0).getTime();
		
		if(time >= 0 && time <= 12000)
		{
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 25);
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
				PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
				return false;
			}
			SpellManaInterface.updateScoreBoard(event.getPlayer());
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			
			try
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
				
				event.getPlayer().setHealth(event.getPlayer().getHealth()+10);		
			}
			catch(IllegalArgumentException e)
			{			
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
				
				event.getPlayer().setHealth(event.getPlayer().getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
			}	
			
			//While day, transform mana into health.
			return true;
		}
		
		if(time >=12005 && time <= 24000)
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_POWER_SELECT, SoundCategory.MASTER, 1, 1);
			event.getPlayer().damage(6);
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() + 75);
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()>PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana());
			}
			SpellManaInterface.updateScoreBoard(event.getPlayer());
			//While night, transform health into mana.
			return true;
		}
		return false;
	}
}
