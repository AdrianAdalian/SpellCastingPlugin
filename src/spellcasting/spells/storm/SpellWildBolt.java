package spellcasting.spells.storm;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellWildBolt extends BaseSpell
{

	public SpellWildBolt()
	{
		super(Material.BOOK, "§r§f§ko§r§fTome: §r§fWildBolt§r§f§ko§r", 20, false, "§r§fElement: §r§dStorm§r§f.","§r§fRandomly summons five bolts of lightning.","§r§fRange to cast: 30 meters.","§r§fRange of lightning: 7 meters.","§r§fDeals 2.5 hearts of §r§cdamage §r§fper lightning bolt.","§r§fMana cost: 20 §r§9mana§r§f.");
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
	
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		Random rand = new Random(); // Create a new random object

		int radiusOfLightningStrike = 7; // Maximum radius, in blocks, for lightning to strike 
		int TARGETBLOCKRADIUS = 30; //the radius in which the spell can be casted on.
		
		Block target = event.getPlayer().getTargetBlock(null, TARGETBLOCKRADIUS) ;
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.MASTER, 1, 1);
		
		event.getPlayer().getWorld().strikeLightning(target.getLocation()) ;
		
		if (target.getType().equals(Material.AIR))
		{
			while (target.getType().equals(Material.AIR)) 
			{
				target = event.getPlayer().getWorld().getBlockAt(target.getLocation().subtract(new Location(event.getPlayer().getWorld(), 0, 1, 0))) ;
			}	
		}
		final Block Actualtarget = target ;
		for (int i = 1; i < 5; i++)
		{
			 new BukkitRunnable()
			  {
			    @Override
			    public void run()
			    {
			    	int offsetX = radiusOfLightningStrike * -1 + rand.nextInt(radiusOfLightningStrike * 2); // Container values for X and Z offsets
					  int offsetZ = radiusOfLightningStrike * -1 + rand.nextInt(radiusOfLightningStrike * 2);

					  // Assume we have some kind of object, like an entity or a block, that has a .getLocation() method
					  Location targetLoc = Actualtarget.getLocation().add(new Location(event.getPlayer().getWorld(), offsetX, 0, offsetZ)); // Add the offset to the strike location
					  targetLoc.getWorld().strikeLightning(targetLoc); // And strike
			    }
			  }.runTaskLater(Zenith.getInstance(), 20*i);
		}	
		return true;
	}
}
