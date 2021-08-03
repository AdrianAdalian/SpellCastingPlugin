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

public class SpellDracoMorph extends BaseSpell
{

	public SpellDracoMorph()
	{
		super(Material.NETHERITE_INGOT, "§r§7§ko§r§7§lSpell: §r§fDracoMorph§r§7§ko§r", 30, true, "§r§fElement: §r§6Geo§r§f.","§r§fDrastically hardens the caster's skin","§r§fwhile increasing movement speed.","§r§fAlso soothes the caster from high temperatures.","§r§fGrant 60% damage reduction and fire protection.","§r§fDuration: 45 seconds.","§r§fMana cost: 30 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			return false;
		}
		//PrintUtils.log(event.getAction().name() , InfoType.INFO) ; 
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_NETHERITE, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 900, 2));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 900, 0));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 900, 0));
		
		 new BukkitRunnable()
		 {
		   @Override
		   public void run()
		   {
			   event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_CHAIN_BREAK, SoundCategory.MASTER, 1, 1);
		   }
		 }.runTaskLater(Zenith.getInstance(), 905);
		 return true; 
	}	
}
