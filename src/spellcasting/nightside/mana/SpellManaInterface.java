package spellcasting.nightside.mana;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.yukiemeralis.blogspot.zenith.utils.JsonUtils;

public class SpellManaInterface implements Listener
{
	@EventHandler
	public void uponLogin(PlayerJoinEvent event) 
	{
		PlayerDataMap.getPlayerData(event.getPlayer());
		setScoreBoard(event.getPlayer());
	}
	
	@EventHandler
	public void uponLogout(PlayerQuitEvent event) 
	{
		JsonUtils.toJsonFile("./plugins/Spellcasting/data/" + event.getPlayer().getUniqueId().toString() + ".json", PlayerDataMap.getPlayerData(event.getPlayer()));
	}
	
	public void setScoreBoard(Player player) 
	{
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		//Makes a new scoreboard.
        Objective obj = board.registerNewObjective("| Mana |", "| Mana |", "| Mana |");
        //Creates our new objective and scoreboard. For whatever reason, Java wants a format of 3's in the cast of scoreboard titles.
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        //Sets the display to the right side of the screen.
        obj.getScore(ChatColor.BLACK + "Current Mana:" + ChatColor.WHITE).setScore(PlayerDataMap.getPlayerData(player).getCurrentMana());
        //Gets the title and the basic score for our mana.
        player.setScoreboard(board);
        //Sets the scoreboard once we've made it.
	}    
    public static void updateScoreBoard(Player player) 
    {
    	 Scoreboard board = player.getScoreboard();
    	 Objective obj = board.getObjective(DisplaySlot.SIDEBAR);
    	 
    	 obj.getScore(ChatColor.BLACK + "Current Mana:" + ChatColor.WHITE).setScore(PlayerDataMap.getPlayerData(player).getCurrentMana());
	}
}


//Score onlineName = obj.getScore(ChatColor.GRAY + "§ Online");
//onlineName.setScore(15);

//Team onlineCounter = board.registerNewTeam("onlineCounter");

//onlineCounter.addEntry(ChatColor.BLACK + "" + ChatColor.WHITE);

/*if (Bukkit.getOnlinePlayers().size() == 0) {
    onlineCounter.setPrefix(ChatColor.DARK_RED + "0" + ChatColor.RED + "/" + ChatColor.DARK_RED + Bukkit.getMaxPlayers());
} else {
    onlineCounter.setPrefix("" + ChatColor.DARK_RED + Bukkit.getOnlinePlayers().size() + ChatColor.RED + "/" + ChatColor.DARK_RED + Bukkit.getMaxPlayers());
}*/
