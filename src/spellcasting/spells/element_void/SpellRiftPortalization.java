package spellcasting.spells.element_void;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellRiftPortalization extends BaseSpell
{

	public SpellRiftPortalization()
	{
		super(Material.ENDER_EYE, "§r§7§ko§r§7§lSpell: §r§fRift Portalization§r§7§ko§r", 25, true, "§r§fElement: §r§3§lVOID§r§f.","§r§fA highly unstable spell containing enough energy","§r§fto grant the caster safe travel between dimensions.","§r§fMana cost: 25 §r§9mana§r§f.");
	}
	
	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		//World nether = Bukkit.getWorld(Bukkit.getWorlds().get(0).getName() + "_nether");
		World nether = Bukkit.getWorld("world_nether");
		
		World overworld = Bukkit.getWorlds().get(0);
		
		int xradius = 75;
		int zradius = 75;

		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.NORMAL))
		{
			double baseX = event.getPlayer().getLocation().getX() / 8;
			double baseZ = event.getPlayer().getLocation().getX() / 8;
			for (int ix = xradius * -1; ix < xradius; ix++)
			{
				for (int iz = zradius * -1; iz < zradius; iz++)
				{
					for (int iy = 126; iy > 0; iy--)
					{
						
						Block current = nether.getBlockAt(new Location(nether, baseX + ix, iy, baseZ + iz));
						
						if (current.getType().equals(Material.LAVA) || current.getType().equals(Material.MAGMA_BLOCK) || current.getType().equals(Material.AIR)) 
						{
							continue;
						}
						
						if (current.getRelative(BlockFace.UP).getType().isAir() && current.getRelative(BlockFace.UP).getRelative(BlockFace.UP).getType().isAir()) 
						{
							
							Bukkit.getWorld("world_nether").loadChunk(current.getChunk());
							
							current.setType(Material.OBSIDIAN); 
							current.getRelative(BlockFace.UP).setType(Material.AIR);
							current.getRelative(BlockFace.UP).getRelative(BlockFace.UP).setType(Material.AIR);
							
							event.getPlayer().teleport(new Location(nether, current.getLocation().getX(), current.getLocation().getY(), current.getLocation().getZ()).add(0.5, 1, 0.5));
							
							return true;
						  //Teleports the caster from the overworld to the nether.
						}
					}
				}
			}
			PrintUtils.sendMessage(event.getPlayer(), "Unsafe Cast Location.");
			return false;
		}
		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.NETHER)) 
		{
			Location loc2 = event.getPlayer().getLocation();
			int overworldX = (int) (loc2.getX() * 8);
			int overworldZ = (int) (loc2.getZ() * 8);
			Block target = Bukkit.getWorld("world").getHighestBlockAt(overworldX, overworldZ);
			
			event.getPlayer().teleport(new Location(overworld, overworldX, target.getLocation().getY(), overworldZ).add(0.5, 1, 0.5));
			return true;
				//Teleports the caster from the nether to the overworld.
		}

		return false;
	}
}
