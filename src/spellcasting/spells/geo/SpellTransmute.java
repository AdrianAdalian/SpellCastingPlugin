package spellcasting.spells.geo;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellTransmute extends BaseSpell
{

	public SpellTransmute()
	{
		super(Material.PHANTOM_MEMBRANE, "§r§7§ko§r§7§lSpell: §r§fTransmute§r§7§ko§r", 15, true, "§r§fElement: §r§6Geo§r§f.","§r§fInfuse any ore with the forces of §r§6Geo§r§f.","§r§fTransmute that ore into its next level of rarity.","§r§fRange: 10 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		int TARGETRANGE = 10;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		
		
		if (target.getType() != null)
		{
			
			if (target.getType().equals(Material.COAL_ORE)) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_IRON, SoundCategory.MASTER, 1, 1);
				target.setType(Material.IRON_ORE);
				return true;
			}
			
			if (target.getType().equals(Material.IRON_ORE)) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_GOLD, SoundCategory.MASTER, 1, 1);
				target.setType(Material.GOLD_ORE);
				return true;
			}
			
			if (target.getType().equals(Material.GOLD_ORE)) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_DIAMOND, SoundCategory.MASTER, 1, 1);
				target.setType(Material.DIAMOND_ORE);
				return true;
			}
			
			if (target.getType().equals(Material.DIAMOND_ORE)) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_NETHERITE, SoundCategory.MASTER, 1, 1);
				target.setType(Material.ANCIENT_DEBRIS);
				return true;
			}
			
			if (target.getType().equals(Material.COPPER_ORE)) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
				target.setType(Material.LAPIS_ORE);
				return true;
			}
			
			if (target.getType().equals(Material.LAPIS_ORE)) 
			{
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
				target.setType(Material.EMERALD_ORE);
				return true;
			}
		}
		return false;
	}
}
