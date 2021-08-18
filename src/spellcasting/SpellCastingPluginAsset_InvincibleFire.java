package spellcasting;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SpellCastingPluginAsset_InvincibleFire implements Listener
{
	
	public static List<Block> invincibleFireBlocks = new ArrayList<>();
	
	@EventHandler
	public void iFire(PlayerInteractEvent event) 
	{
		if (invincibleFireBlocks.contains(event.getClickedBlock()))
		{
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				return;
			}
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				return;
			}
		}
	}
}
