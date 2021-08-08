package spellcasting.divineweapon.weapon_spell_item;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.ChatUtils;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class DivineWeapon_WandOfFire extends BaseSpell
{

	public DivineWeapon_WandOfFire()
	{
		super(Material.STICK, ChatUtils.of("Magic Weapon: Wand of Fire", "FFE748","FF1919","§l§o"), 5, false, "§r§fElement: §r§cFire§r§f.","§r§fA simple stick infused with the element of §r§cFire§r§f.","§r§fExpell a tiny burst of flame towards a target.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		
		SmallFireball fireball = event.getPlayer().launchProjectile(SmallFireball.class);
		fireball.setVelocity(fireball.getVelocity().multiply(10));
		return true;
	}
}
