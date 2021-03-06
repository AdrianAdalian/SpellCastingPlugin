package spellcasting.spells.fire;

import java.awt.Color;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.DragonFireball;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.spells.BaseSpell;

public class SpellDragonAshes extends BaseSpell
{

	
	public SpellDragonAshes()
	{
		super(Material.FIREWORK_STAR, "§r§e§ko§r§e§lRelic: §r§fDragon Ashes§r§e§ko§r", 30, true, "§r§fElement: §r§cFire§r§f.","§r§fAshes collected from the remains of a dragon.","§r§fThese ashes radiate pure §r§cFire§r§f energy.","§r§fSummon a blistering dragons' flame that","§r§fleaves behind a damaging AOE upon contact.","§r§fMana cost: 30 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDER_DRAGON_SHOOT, SoundCategory.MASTER, 1, 1);
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, Color.MAGENTA);
		
		DragonFireball dragonfireball = event.getPlayer().launchProjectile(DragonFireball.class) ;
		dragonfireball.setVelocity(dragonfireball.getVelocity().multiply(2));
		return true;
	}
}
