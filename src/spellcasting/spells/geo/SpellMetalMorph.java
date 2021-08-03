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

public class SpellMetalMorph extends BaseSpell
{

	public SpellMetalMorph()
	{
		super(Material.IRON_INGOT, "§r§7§ko§r§7§lSpell: §r§fMetalMorph§r§7§ko§r", 10, true, "§r§fElement: §r§6Geo§r§f.","§r§fModerately hardens the caster's skin.","§r§fGrant 40% damage reduction.","§r§fModerately decreases caster movment speed.","§r§fDuration: 25 seconds.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		//PrintUtils.log(event.getAction().name() , InfoType.INFO) ; 
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_IRON, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 500, 1));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 1));
		
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1);
		   }
		 }.runTaskLater(Zenith.getInstance(), 505);
		 return true;
	}	
}
