package spellcasting.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellRipTide extends BaseSpell
{

	public SpellRipTide()
	{
		super(Material.LIGHT_BLUE_DYE, "§r§7§ko§r§7§lSpell: §r§fRiptide§r§7§ko§r", 5, false, "§r§fElement: §r§9Water§r§f.","§r§fSlightly boosts the caster through water.","§r§fMana cost: 5 §r§9mana§r§f.");
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
			event.getPlayer().setVelocity(event.getPlayer().getLocation().getDirection().multiply(1.5));
			new BukkitRunnable()
			{
				 @Override
				  public void run()
				  {
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_TRIDENT_RIPTIDE_1, SoundCategory.MASTER, 1, 1);
				  }
			}.runTaskLater(Zenith.getInstance(), 10);
			return true;
		}
		return false;
	}
}