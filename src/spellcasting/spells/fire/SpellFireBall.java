package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.Fireball;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import spellcasting.spells.BaseSpell;

public class SpellFireBall extends BaseSpell
{

	public SpellFireBall()
	{
		super(Material.FIRE_CHARGE, "§r§7§ko§r§7§lSpell: §r§fFireBall§r§7§ko§r", 10, false, "§r§fElement: §r§cFire§r§f.", "§r§fSummons a small ball of fire.","§r§fDeals 5 hearts of §r§cdamage§r§f.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
		
		Fireball fireball = event.getPlayer().launchProjectile(Fireball.class) ;
		fireball.setVelocity(fireball.getVelocity().multiply(5));
		return true;
	}
}