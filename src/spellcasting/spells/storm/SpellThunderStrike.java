package spellcasting.spells.storm;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellThunderStrike extends BaseSpell
{
	
	public SpellThunderStrike()
	{
		super(Material.PURPLE_DYE, "§r§7§ko§r§7§lSpell: §r§fThunderStrike§r§7§ko§r", 20, false, "§r§fElement: §r§dStorm§r§f.","§r§fSummons two consecutive lightning bolts.","§r§fRange: 20 meters.","§r§fDeals 5 hearts of §r§cdamage§r§f.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		int TARGETRANGE = 20 ;
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
		
		if (target.getType().equals(Material.AIR))
		{
			return false;			
		}
		
		event.getPlayer().getWorld().strikeLightning(target.getLocation()) ;		
		
		new BukkitRunnable()
		{
		  @Override
		  public void run()
		  {
			  event.getPlayer().getWorld().strikeLightning(target.getLocation()) ;
		  }
		}.runTaskLater(Zenith.getInstance(), 20);
		return true;
	}
}
