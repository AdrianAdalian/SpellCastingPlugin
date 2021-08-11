package spellcasting.divineweapon.weapon_spell_item;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.entity.SmallFireball;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.yukiemeralis.blogspot.zenith.utils.ChatUtils;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.spells.BaseSpell;

public class DivineWeapon_WandOfFire extends BaseSpell
{

	public DivineWeapon_WandOfFire()
	{
		super(Material.STICK, ChatUtils.of("Magic Weapon: Wand of Fire", "FFE748","FF1919","§l§o"), 0, false, "§r§fElement: §r§cFire§r§f.","§r§fA simple stick infused with the element of §r§cFire§r§f.","§r§7§lSpell: §r§fEmber.","§r§f[Left Click] Cast a tiny burst of flame towards a target.","§r§fMana cost: 5 §r§9mana§r§f.","§r§6Ability§r§f: Nullify Temperature.","§r§f[Right Click] Grant brief heat aborption.","§r§fDuration: 10 seconds.","§r§fMana cost: 5 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (event.getAction().equals(Action.LEFT_CLICK_AIR)) 
		{
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
				PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
				return false;
			}
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
			
			SmallFireball fireball = event.getPlayer().launchProjectile(SmallFireball.class);
			fireball.setVelocity(fireball.getVelocity().multiply(10));
			return true;
		}
		
		if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
				PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
				return false;
			}
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
			
			event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 200, 0));
			return true;
		}
		return false;
		
	}
}
