package spellcasting.spells.unholy;

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

public class SpellDemonSight extends BaseSpell
{

	public SpellDemonSight()
	{
		super(Material.GRAY_DYE, "§r§7§ko§r§7§lSpell: §r§fDemon Sight§r§7§ko§r", 10, false, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fGrant caster temporary Night Vision.","§r§fDuration: 30 seconds.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false; 
		}
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
		
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 600, 0));
			
			new BukkitRunnable()
			{
			  @Override
			  public void run()
			  {
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
			  }
			}.runTaskLater(Zenith.getInstance(), 605);
			return true;
	}
}
