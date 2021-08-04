package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellFlamethrower extends BaseSpell
{

	public SpellFlamethrower()
	{
		super(Material.FIRE_CHARGE, "§r§7§ko§r§7§lSpell: §r§fFlamethrower§r§7§ko§r", 20, true, "§r§fElement: §r§cFire§r§f.", "§r§fSummons three consective balls of flame.","§r§fThird ball deals 5 hearts of §r§cdamage§r§f.","§r§fMana cost: 20 §r§9mana§r§f.");
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
		
		SmallFireball largefireball = event.getPlayer().launchProjectile(SmallFireball.class) ;
		largefireball.setVelocity(largefireball.getVelocity().multiply(10));
		
		new BukkitRunnable()
		{

			@Override
			public void run()
			{
			
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
				SmallFireball largefireball = event.getPlayer().launchProjectile(SmallFireball.class) ;
				largefireball.setVelocity(largefireball.getVelocity().multiply(10));
				
			}
			
		}.runTaskLater(Zenith.getInstance(), 5);
		
		new BukkitRunnable()
		{

			@Override
			public void run()
			{
			
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
				LargeFireball largefireball = event.getPlayer().launchProjectile(LargeFireball.class) ;
				largefireball.setVelocity(largefireball.getVelocity().multiply(2));
				
			}
			
		}.runTaskLater(Zenith.getInstance(), 20);
		return true;
	}
}
