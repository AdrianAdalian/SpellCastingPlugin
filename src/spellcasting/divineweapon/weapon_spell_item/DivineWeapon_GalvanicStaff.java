package spellcasting.divineweapon.weapon_spell_item;

import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class DivineWeapon_GalvanicStaff extends BaseSpell
{

	public DivineWeapon_GalvanicStaff(Material material, String displayName, int manaCost, boolean glow,
			String[] displayLore)
	{
		super(material, displayName, manaCost, glow, displayLore);
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		
		
		return false;
	}

}
