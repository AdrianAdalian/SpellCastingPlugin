package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_BaseFireBall;

public class SpellFireBall extends BaseSpell
{

	public SpellFireBall()
	{
		super(Material.FIRE_CHARGE, "§r§7§ko§r§7§lSpell: §r§fFireBall§r§7§ko§r", 10, false, "§r§fElement: §r§cFire§r§f.", "§r§fSummons a small ball of fire.","§r§fDeals 5 hearts of §r§cdamage§r§f.","§r§fRange: 20 meters.","§r§fMana cost: 10 §r§9mana§r§f.");
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
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, null);
		//casting animation for Element: Fire.
		new SpellProjectile_BaseFireBall().launch(event.getPlayer());
		return true;
	}
}