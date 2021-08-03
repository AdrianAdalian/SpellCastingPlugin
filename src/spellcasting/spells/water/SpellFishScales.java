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

import spellcasting.spells.BaseSpell;

public class SpellFishScales extends BaseSpell
{

	public SpellFishScales()
	{
		super(Material.PRISMARINE_CRYSTALS, "§r§7§ko§r§7§lSpell: §r§fFish Scales§r§7§ko§r", 10, true, "§r§fElement: §r§9Water§r§f.","§r§fHardens the caster's flesh into fish scales.","§r§fGrants 20% damage reduction and faster swim speed.","§r§fDuration: 20 seconds.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_CHAIN, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 400, 0));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 400, 0));
		 
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1);
		   }
		 }.runTaskLater(Zenith.getInstance(), 405);
		return true;
	}
}
