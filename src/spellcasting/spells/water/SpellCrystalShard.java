package spellcasting.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_CrystalShard;

public class SpellCrystalShard extends BaseSpell
{

	public SpellCrystalShard()
	{
		super(Material.PRISMARINE_SHARD, "§r§e§ko§r§e§lRelic: §r§fCrystal Shard§r§e§ko§r", 10, true, "§r§fElement: §r§9Water§r§f.","§r§fA prismarine shard enchanted by the forces of §r§9Water§r§f.","§r§fShoot out a damaging projectile that slows the target.","§r§fDeals 3 hearts of §r§cdamage§r§f.","§r§fEffect duration: 10 seconds.","§r§fRange: 10 meters.","§r§fMana cost: 10 §r§9mana§r§f.");		
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_AMETHYST_BLOCK_BREAK, SoundCategory.MASTER, 1, 1);
		
		new SpellProjectile_CrystalShard().launch(event.getPlayer());
		return true;
	}
}
