package spellcasting.divineweapon.weapon_spell_item;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_Boulder;

public class DivineWeapon_StaffOfElements extends BaseSpell
{

	public DivineWeapon_StaffOfElements()
	{
		super(Material.STICK, "Name PH", 0, true, "Lore");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() == 2)
		{
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Savanna].");
				return false;
			}
			
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Savanna].");
				return false;
			}
			
			if(event.getAction().equals(Action.LEFT_CLICK_AIR)) 
			{
				
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 10);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FIRECHARGE_USE, SoundCategory.MASTER, 1, 1);
				
				LargeFireball fireball = event.getPlayer().launchProjectile(LargeFireball.class);
				fireball.setVelocity(fireball.getVelocity().multiply(1));
				return true;
				//Sol Prime.
			}
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
			{
			
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 15);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_ACTIVATE, SoundCategory.MASTER, 1, 1);
				
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400, 0));	
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 400, 9));
				event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 0));
					
				new BukkitRunnable()
				{
					@Override
					public void run()
					{
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, SoundCategory.MASTER, 1, 1);
					}
				}.runTaskLater(Zenith.getInstance(), 405);	
				return true;
				//Spell: Metabolize.
			}
			//Extremely Hot Climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= 1.0 && event.getPlayer().getLocation().getBlock().getTemperature() <= 1.2)
		{
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Desert].");
				return false;
			}
			
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Desert].");
				return false;
			}
			
			if(event.getAction().equals(Action.LEFT_CLICK_AIR)) 
			{
				
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				
				LivingEntity target1 = (LivingEntity) getNearestEntityInSight(event.getPlayer(), 5);
				
				if (target1 == null) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
				
				target1.setVelocity(target1.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
				target1.setFireTicks(160);
				
				return true;
				
				//Spell Heat Blast.
			}
			
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
			{
			
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 15);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				if (event.getPlayer().getNearbyEntities(7, 7, 7).size() == 0)
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				for (Entity target0 : event.getPlayer().getNearbyEntities(7, 7, 7)) 
				{
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 1, 1);
					
					target0.setVelocity(target0.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
					target0.setFireTicks(200);
					
					return true; 
				}
				//Spell Solar Expansion.
				
			}
			//Moderately hot climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= 0.5 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.95)
		{
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Rocky/Aquatic].");
				return false;
			}
			
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Rocky/Aquatic].");
				return false;
			}
			
			if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 10);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				if (event.getPlayer().getNearbyEntities(10, 10, 10).size() == 0)
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				for (Entity target : event.getPlayer().getNearbyEntities(10, 10, 10)) 
				{
					if (target instanceof LivingEntity)
			    	{
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
						target.setVelocity(target.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()).multiply(-1).normalize());
						((LivingEntity) target).damage(4);
			    		((LivingEntity) target).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 150, 0));
			    		return true;
			    	}  
				}	
				
				//Spell Collapsing Vortex.
			}
			
			if(event.getAction().equals(Action.LEFT_CLICK_AIR)) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				
				if (event.getPlayer().getNearbyEntities(10, 10, 10).size() == 0)
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				for (Entity target2 : event.getPlayer().getNearbyEntities(10, 10, 10)) 
				{
					if (target2 instanceof LivingEntity) 
					{
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_DRIPSTONE_BLOCK_BREAK, SoundCategory.MASTER, 1, 1);
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_ANVIL_BREAK, SoundCategory.MASTER, 1, 1);
						
						((LivingEntity) target2).damage(4);
						((LivingEntity) target2).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 99));
						target2.setVelocity(target2.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()).multiply(1.5).normalize());
						return true;
					}
				}
				
				//Spell Expanding Tremor.
			}
			//Temperate Only Climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= 0.2 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.3)
		{
			
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Cold].");
				return false;
			}
			
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Cold].");
				return false;
			}
			
			if (event.getAction().equals(Action.LEFT_CLICK_AIR)) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SNOWBALL_THROW, SoundCategory.MASTER, 1, 1);
				
				new SpellProjectile_Boulder().launch(event.getPlayer());
				return true;
			}
			//Spell: IcicleSpear
			
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
				int TARGETRANGE = 5 ;
				
				Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
				
				if (target.getType().equals(Material.AIR))
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;			
				}
				if (target.getType() != null)
				{
					
					if (target.getType().equals(Material.WATER)) 
					{
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
						target.setType(Material.ICE);
						return true;
					}
					if (target.getType().equals(Material.ICE)) 
					{
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_GLASS_BREAK, SoundCategory.MASTER, 1, 1);
						target.setType(Material.WATER);
						return true;
					}
				}
			//Ability: Liquidate. Turns water into ice and vice versa.
			}
			//Cold Climates.
		}
		
		if(event.getPlayer().getLocation().getBlock().getTemperature() >= -0.7 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.05)
		{
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Cold].");
				return false;
			}
			
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Cold].");
				return false;
			}
			
			//Frigid Climates.
		}
		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.NETHER))
		{
			
			
			//You're in literal Hell, mate.
		}
		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.THE_END))
		{
			
			
			//Void Climate.
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
