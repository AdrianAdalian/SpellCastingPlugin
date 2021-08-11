package spellcasting.divineweapon.weapon_spell_item;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.yukiemeralis.blogspot.zenith.utils.ChatUtils;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.nightside.mana.SpellManaInterface;
import spellcasting.spells.BaseSpell;

public class DivineWeapon_NetherScythe extends BaseSpell
{

	public DivineWeapon_NetherScythe()
	{
		super(Material.NETHERITE_HOE, ChatUtils.of("Magic Weapon: Defiled Scythe", "FFE748","581845","§l§o"), 0, true, "§r§fElement: §r§4§o§lUnholy§r§f.","§r§fA gardening tool defiled by the §r§4§o§lUnholy§r§f.","§r§6Ability§r§f: Mana Harvest.","§r§f[Right Click] While targeting an enemy mob,","§r§4Drain§r§f 10 §r§9mana§r§f while dealing 1 heart of §r§cdamage§r§f.","§r§fRange: 10 meters.","§r§6Ability§r§f: Expiate.","§r§f[Right Click] If a target is unavailable, grant","§r§fincreased interact speed and damage output.","§r§fDuration: 15 seconds.","§r§fMana cost: 15 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if(!event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
		{
			return false;
		}
		
		Entity target = getNearestEntityInSight(event.getPlayer(), 10);
		if (target instanceof Damageable)
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_AMBIENT, SoundCategory.MASTER, 1, 1);
			
			((Damageable) target).damage(2, event.getPlayer());
			
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() + 10);
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()>PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana());
			}
			SpellManaInterface.updateScoreBoard(event.getPlayer());
			
			return true;
		}
		
		if(target==null) 
		{
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 15);
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
				PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
				return false;
			}
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_WITHER_SPAWN, SoundCategory.MASTER, 1, 1);
			event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 300, 0));
			event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 300, 0));
			
			return true;
		}
		
		return false;
	}
	private Entity getNearestEntityInSight(Player player, int range) 
	{
		
	    ArrayList<Entity> entities = (ArrayList<Entity>) player.getNearbyEntities(range, range, range);
	    ArrayList<Block> sightBlock = null;
	    try 
	    {
	        sightBlock = (ArrayList<Block>) player.getLineOfSight(null, range);
	    } catch (IllegalStateException error) 
	    {
	        return null;
	    }
	     
	    ArrayList<Location> sight = new ArrayList<Location>();
	    for (int i = 0;i<sightBlock.size();i++)
	        sight.add(sightBlock.get(i).getLocation());
	    for (int i = 0;i<sight.size();i++) {
	        for (int k = 0;k<entities.size();k++) {
	            if (entities.get(k) instanceof LivingEntity && !(entities.get(k) instanceof ArmorStand)) {
	                if (Math.abs(entities.get(k).getLocation().getX()-sight.get(i).getX())<1.3) {
	                    if (Math.abs(entities.get(k).getLocation().getY()-sight.get(i).getY())<1.5) {
	                        if (Math.abs(entities.get(k).getLocation().getZ()-sight.get(i).getZ())<1.3) {
	                                
	                        	return entities.get(k);
	                        	
	                        }
	                    }
	                }
	            }
	        }
	    }
	    	return null; // Return null if no entity was found
	}

}
