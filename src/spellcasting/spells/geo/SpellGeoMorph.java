package spellcasting.spells.geo;

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

public class SpellGeoMorph extends BaseSpell
{

	public SpellGeoMorph()
	{
		super(Material.BRICK, "§r§7§ko§r§7§lSpell: §r§fGeoMorph§r§7§ko§r", 5, true, "§r§fElement: §r§6Geo§r§f.","§r§fSlightly hardens the caster's skin.", "§r§fGrant 20% damage reduction.","§r§fSlightly decreases caster movment speed.","§r§fDuration: 15 seconds.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		//PrintUtils.log(event.getAction().name() , InfoType.INFO) ; 
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300, 0));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 300, 0));
		 
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1);
		   }
		 }.runTaskLater(Zenith.getInstance(), 305);
		 return true;
	}
}
