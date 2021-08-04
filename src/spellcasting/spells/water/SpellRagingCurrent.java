package spellcasting.spells.water;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellRagingCurrent extends BaseSpell
{

	public SpellRagingCurrent()
	{
		super(Material.LIGHT_BLUE_DYE, "§r§7§ko§r§7§lSpell: §r§fRaging Current§r§7§ko§r", 15, true, "§r§fElement: §r§9Water§r§f.","§r§fSummon a raging current that","§r§fdrastically increases caster swim speed.","§r§fDuration: 30 seconds.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_ACTIVATE, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 600, 0));
		
		new BukkitRunnable()
		{
			@Override
			public void run()
			{
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CONDUIT_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			}
		}.runTaskLater(Zenith.getInstance(), 405);
		return true;
	}	
}
