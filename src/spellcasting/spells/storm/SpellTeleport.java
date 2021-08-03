package spellcasting.spells.storm;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;

import spellcasting.spells.BaseSpell;

public class SpellTeleport extends BaseSpell
{

	public SpellTeleport()
	{
		super(Material.STRING, "§r§7§ko§r§7§lSpell: §r§fTeleport§r§7§ko§r", 15, true, "§r§fElement: §r§dStorm§r§f.","§r§fTeleport a far distance away.","§r§fRange: 25 meters.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		{ 
			
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return false;
			}
			
			int TARGETRANGE = 25 ;
			
			float YAW = event.getPlayer().getLocation().getYaw() ;
			float PITCH = event.getPlayer().getLocation().getPitch() ; //float is a variable that is a decimal, we can use this to get a rotated object/pitch/yaw.
			
			Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
			
			while (target.getType().equals(Material.AIR)) 
			{
				target = event.getPlayer().getWorld().getBlockAt(target.getLocation().subtract(new Location(event.getPlayer().getWorld(), 0.5, 1, 0.5))) ;
			}
			new BukkitRunnable()
			{
				 @Override
				  public void run()
				  {
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, SoundCategory.MASTER, 1, 1);
				  }
			}.runTaskLater(Zenith.getInstance(), 10);
			Location newlocation = target.getLocation().add(new Location(event.getPlayer().getWorld(), 0.5, 1, 0.5)) ;
			newlocation.setYaw(YAW);
			newlocation.setPitch(PITCH);
			
			//Location newlocation is a defined variable that we are using to store a player float (yaw/pitch), and then plugging this information into the teleport.
			
			event.getPlayer().teleport(newlocation);
			return true;
		}
	}
}
