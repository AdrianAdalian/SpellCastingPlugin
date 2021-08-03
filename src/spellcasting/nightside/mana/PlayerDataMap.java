package spellcasting.nightside.mana;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;

import com.yukiemeralis.blogspot.zenith.utils.JsonUtils;

public class PlayerDataMap
{

	private static Map<Player, StorePlayerData_Mana> mana_registry = new HashMap<>();
	
	public static StorePlayerData_Mana getPlayerData(Player player) 
	{
		
		if (mana_registry.containsKey(player)) 
		{
			return mana_registry.get(player);
		}
		
		StorePlayerData_Mana data;
		
		File file = new File("./plugins/Spellcasting/data/" + player.getUniqueId().toString() + ".json");
		
		if (!file.exists()) 
		{
			data = new StorePlayerData_Mana();
			JsonUtils.toJsonFile(file.getAbsolutePath(), data);
			mana_registry.put(player, data);
			return data;
			//creates a file for player data if it doesn't already exists.
		}
		
		data = (StorePlayerData_Mana) JsonUtils.fromJsonFile(file.getAbsolutePath(), StorePlayerData_Mana.class);
		if (data == null) 
		{
			data = new StorePlayerData_Mana();
			JsonUtils.toJsonFile(file.getAbsolutePath(), data);
			mana_registry.put(player, data);
			return data;
			
			//checks to see if the data is corrupted, if true, then it will recreate that player data.
		}
		//if the player data is not == null, then we return the file's data.
		mana_registry.put(player, data);
		return data;
		
	}
	
	public static Map<Player, StorePlayerData_Mana> getalldata()
	{
		return mana_registry;
	}
	
	
}
