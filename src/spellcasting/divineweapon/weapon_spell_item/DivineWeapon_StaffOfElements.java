package spellcasting.divineweapon.weapon_spell_item;

import org.bukkit.Material;
import org.bukkit.World.Environment;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class DivineWeapon_StaffOfElements extends BaseSpell
{

	public DivineWeapon_StaffOfElements()
	{
		super(material, displayName, manaCost, 0, displayLore);
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if(!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false;
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= 1.0 && event.getPlayer().getLocation().getBlock().getTemperature() <= 1.2)
		{
			
			
			//Moderately hot climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() == 2)
		{
			
			
			//Extremely Dry Climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= 0.5 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.95)
		{
			
			
			//Temperate Only Climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= 0.2 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.3)
		{
			
			
			//Cold Climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= -0.7 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.05)
		{
			
			
			//Frigid Climates..
		}
		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.NETHER))
		{
			
			
			//You're in literal Hell, mate.
		}
		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.THE_END))
		{
			
			
			//Void Climate.
		}
		
		return false;
	}

}
