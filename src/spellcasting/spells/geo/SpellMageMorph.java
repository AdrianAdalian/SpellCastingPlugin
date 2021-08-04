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
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.spells.BaseSpell;

public class SpellMageMorph extends BaseSpell
{

	public SpellMageMorph()
	{
		super(Material.GOLD_INGOT, "§r§7§ko§r§7§lSpell: §r§fMageMorph§r§7§ko§r", 15, true, "§r§fElement: §r§6Geo§r§f.","§r§fSlighty hardens the caster's skin","§r§fwhile increasing movement speed.","§r§fAlso soothes the caster from high temperatures.","§r§fGrant 20% damage reduction and fire protection.","§r§fDuration: 25 seconds.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		//PrintUtils.log(event.getAction().name() , InfoType.INFO) ; 
		
		 event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_DIAMOND, SoundCategory.MASTER, 1, 1);
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 500, 0));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 500, 0));
		 event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 0));
		 
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
