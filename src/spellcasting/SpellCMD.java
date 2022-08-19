package spellcasting;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.yukiemeralis.blogspot.zenith.command.ZenithCommand;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.nightside.mana.SpellManaInterface;

public class SpellCMD extends ZenithCommand
{

	public SpellCMD()
	{
	
		super("magik");
		
	}
	
	@ZenCommandHandler(usage = "magik", description = "Give player spell item.", argsCount = 0, minAuthorizedRank = 3)
	public void zcommand_nosubcmd(CommandSender sender, String commandLabel, String[] args)
	{
		//SpellGUI_Storm gui = new SpellGUI_Storm();
		//gui.init();
		//gui.display((Player) sender);
	}
	
	@ZenCommandHandler(usage = "magik", description = "Give player spell item.", argsCount = 2, minAuthorizedRank = 3)
	public void zcommand_give(CommandSender sender, String commandlabel, String[] args)
	{
		
		// switchcase is an if statement that will run a specific set of code if a variable is something.
	   //  this command line allows us to give the sender (the player in this case) the spell item we are wanting to use.
		
		if (args[1].equals("MaxMana"))
		{
			PlayerDataMap.getPlayerData((Player) sender).setCurrentMana(PlayerDataMap.getPlayerData((Player) sender).getMaxMana());
			SpellManaInterface.updateScoreBoard((Player) sender);
			return;
		}
		
		
		ItemStack spellitem = CastListener.spell_registry.get(args[1]).toIcon();
		
		((Player) sender).getInventory().addItem(spellitem) ;
	
	}
}

//spellitem = CastListener.spell_registry.get(args[1]).toIcon();