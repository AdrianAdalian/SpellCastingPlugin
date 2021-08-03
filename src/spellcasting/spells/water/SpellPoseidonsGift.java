package spellcasting.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.nightside.mana.SpellManaInterface;
import spellcasting.spells.BaseSpell;

public class SpellPoseidonsGift extends BaseSpell
{

	public SpellPoseidonsGift()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fPoseidon's Gift§r§f§ko§r", 0, false, "§r§fElement: §r§9Water§r§f.","§r§fAn enchantment used to soothe one's body.","§r§fRegenerate the caster's mana while in swimming.","§r§fRestores 20 §r§9Mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false;
		}
		if (event.getPlayer().isSwimming())
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);			
		
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() + 20);
			
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()>PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana());
			}
			
			SpellManaInterface.updateScoreBoard(event.getPlayer());
			return true;
		}
		return false;
	}
}
