package spellcasting.divineweapon.weapon_spell_item;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.World.Environment;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Damageable;
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
import com.yukiemeralis.blogspot.zenith.utils.ChatUtils;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.SpellCastingPluginAsset_InvincibleFire;
import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.DivineWeapon_StaffOfElements_IcicleSpear_Projectile;
import spellcastingprojectiles.DivineWeapon_StaffOfElements_PowderSnow_Projectile;

public class DivineWeapon_StaffOfElements extends BaseSpell
{

	public DivineWeapon_StaffOfElements()
	{
		super(Material.STICK, ChatUtils.of("Magic Weapon: Staff of Elements", "FFE748","40E0D0","§l§o"), 0, true, "§r§fAn enchanted staff that behaves differently","§r§fdepending on surrounding environment.",
				"§r§fIn §r§eDesert §r§fclimates:","§r§7§lSpell: §r§fSol Prime [Left Click Air].","§r§fSummon a super heated ball of fire costing 10 §9Mana§f/cast.","§r§6Ability:§r§f Metabolize [Right Click Air].","§r§fIncrease interact speeds and damage","§r§foutput at the cost of extreme hunger.","§r§fMana cost: 15 §r§9mana§r§f.",
				"§r§fIn §r§2Savannah climates:","§r§7§lSpell: §r§fHeat Blast [Left Click Air].","§r§fExpel a burst of hot air that burns and launches the target.","§r§fRange: 7 meters.","§r§fMana cost: 5 §r§9mana§r§f.",
				"§r§fIn §r§bRocky/Aquatic climates:", "§r§7§lSpell: §r§fCollapsing Vortex [Right Click Air]","§r§fSummon a wave around the caster, slowing and pulling those within range.","§r§fRange: 10 meters and 10 §r§9mana§r§f/cast.","§r§7§lSpell: §r§fExpanding Tremor [Left Click Air].","§r§fSummon a fissure around the caster.","§r§fDamage and launch those within range.","§r§fRange: 10 meters and 10 §r§9mana§r§f/cast.",
				"§r§f");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.NORMAL))
		{
			if(event.getPlayer().getLocation().getBlock().getTemperature() == 2)
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
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Savannah].");
					return false;
				}
				
				if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Savannah].");
					return false;
				}
				if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Savannah].");
					return false;
				}
				LivingEntity target1 = (LivingEntity) getNearestEntityInSight(event.getPlayer(), 7);
				
				if (target1 == null) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
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

					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
					
					target1.setVelocity(target1.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
					target1.setFireTicks(160);
					
					return true;
					
					//Spell Heat Blast.
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
					if (event.getPlayer().getNearbyEntities(10, 10, 10).size() == 0)
					{
						PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
						return false;
					}
					
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 10);
					if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
					{
						PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
						PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
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
				    		
				    	}  
					}	
					return true;
					//Spell Collapsing Vortex.
				}
				
				if(event.getAction().equals(Action.LEFT_CLICK_AIR)) 
				{
					if (event.getPlayer().getNearbyEntities(10, 10, 10).size() == 0)
					{
						PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
						return false;
					}
					
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 10);
					if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
					{
						PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
						PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
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
							target2.setVelocity(target2.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()).multiply(1).normalize());
							
						}
					}
					return true;
					//Spell Expanding Tremor.
				}
			
				//Temperate Only Climates.
			}
			
			if(event.getPlayer().getLocation().getBlock().getTemperature() >= 0.2 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.3)
			{
				
				if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
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
					
					new DivineWeapon_StaffOfElements_PowderSnow_Projectile().launch(event.getPlayer());
					return true;
				}
				//Spell: Powder Snow.
				
				if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
				{
					int TARGETRANGE = 5 ;
					
					Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
					
//					if (target.getType().equals(Material.AIR))
//					{
//						PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
//						return false;			
//					}
					if (target==null) 
					{
						PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
						return false;
					}
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
					if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
					{
						PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
						PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
						return false;
					}
	
					if (target.getType().equals(Material.WATER)) 
					{
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
						target.setType(Material.ICE);
						return true;
					}
					if (target.getType().equals(Material.ICE)) 
					{
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_BONE_MEAL_USE, SoundCategory.MASTER, 1, 1);
						event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_GLASS_BREAK, SoundCategory.MASTER, 1, 1);
						target.setType(Material.WATER);
						return true;
					}
				}
				//Ability: Liquidate. Turns water into ice and vice versa.
				//Cold Climates.
			}
			
			if(event.getPlayer().getLocation().getBlock().getTemperature() >= -0.7 && event.getPlayer().getLocation().getBlock().getTemperature() <= 0.05)
			{
				if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Frigid].");
					return false;
				}
				
				if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Frigid].");
					return false;
				}
				
				if (event.getAction().equals(Action.LEFT_CLICK_AIR)) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 15);
					if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
					{
						PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
						PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
						return false;
					}
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_SNOWBALL_THROW, SoundCategory.MASTER, 1, 1);
					
					new DivineWeapon_StaffOfElements_IcicleSpear_Projectile().launch(event.getPlayer());
					return true;
				}
				//spell: Icicle Spear.
				if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 15);
					if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
					{
						PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
						PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
						return false;
					}
					int radius = 10;
					for (int iy = (radius * -1); iy < (radius * 2); iy++)
					{
						for (int ix = (radius * -1); ix < (radius * 2); ix++)
						{
							for (int iz = (radius * -1); iz < (radius * 2); iz++)
							{
								
								Block target = event.getPlayer().getWorld().getBlockAt(event.getPlayer().getLocation().add(new Location(event.getPlayer().getWorld(), ix, iy, iz)));
									
								if (target.getBlockData() != null)
								{
									if (target.getType().equals(Material.WATER)) 
									{
										event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.AMBIENT_UNDERWATER_EXIT, SoundCategory.MASTER, 1, 1);
										target.setType(Material.ICE);
									}
									if (target.getType().equals(Material.ICE)) 
									{
										event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.BLOCK_GLASS_BREAK, SoundCategory.MASTER, 1, 1);
										target.setType(Material.WATER);
									}
								}	
							}
						}
					}
					return true;
				}
				//Ability: Glaciate.
				//Frigid Climates.
			}
		}
		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.NETHER))
		{
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [Nether].");
				return false;
			}
			
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				int TARGETRANGE = 5;
				
				Block target = event.getPlayer().getTargetBlock(null, TARGETRANGE) ;
				
				if (target==null) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				
				if (event.getClickedBlock().getType().equals(Material.SOUL_FIRE) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
				{
					event.setCancelled(true);
					return false;
				}
				if (event.getClickedBlock().getType().equals(Material.FIRE) && event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
				{
					event.setCancelled(true);
					return false;
				}
				
				if (target.getType().equals(Material.NETHERRACK))
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
					if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
					{
						PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
						PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
						return false;
					}
					Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.FLAME, null);
					
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, SoundCategory.MASTER, 1, 1);
					
					SpellCastingPluginAsset_InvincibleFire.invincibleFireBlocks.add(target.getRelative(BlockFace.UP));
					
					target.getRelative(BlockFace.UP).setType(Material.FIRE);
					
					return true;
				}
				
				if (target.getType().equals(Material.SOUL_SAND)) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 5);
					if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
					{
						PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
						PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
						return false;
					}
					Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.SOUL_FIRE_FLAME, null);
					
					event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_FLINTANDSTEEL_USE, SoundCategory.MASTER, 1, 1);
					
					SpellCastingPluginAsset_InvincibleFire.invincibleFireBlocks.add(target.getRelative(BlockFace.UP));
					
					target.setType(Material.SOUL_FIRE);

					return true; 
				}
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
				return false;
				//Spell: Hell fire.
			}
			
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
			{
				if (event.getPlayer().getNearbyEntities(15, 15, 15).size() == 0)
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 20);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
				event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 1, 1);
				for (Entity target0 : event.getPlayer().getNearbyEntities(15, 15, 15)) 
				{
					if (target0 instanceof Damageable) 
					{
						((Damageable) target0).damage(6, event.getPlayer());
					}
					target0.setVelocity(target0.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
					target0.setFireTicks(100);
				}
				
				//Spell Minor Eruption.
				return true; 
			}
			
			if (event.getAction().equals(Action.LEFT_CLICK_AIR)) 
			{
				LivingEntity target = (LivingEntity) getNearestEntityInSight(event.getPlayer(), 10);
				
				if (target==null) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 10);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}
				
				target.getWorld().createExplosion(target.getLocation(), 1	);
				
				//Spell Spontaneous Combustion.
				return true;
			}
			//You're in literal Hell, mate.
		}
		
		if(event.getPlayer().getWorld().getEnvironment().equals(Environment.THE_END))
		{
			if (event.getAction().equals(Action.LEFT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [VOID].");
				return false;
			}
			if (event.getAction().equals(Action.LEFT_CLICK_AIR)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [VOID].");
				return false;
			}
			if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) 
			{
				PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method For Climate: [VOID].");
				return false;
			}
			
			if (event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
			{
				Entity target = (Entity) getNearestEntityInSight(event.getPlayer(), 10);
				
				if (target==null) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
					return false;
				}
				if (target instanceof Player) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target: [PLAYER].");
					return false;
				}
				if (target instanceof Boss) 
				{
					PrintUtils.sendMessage(event.getPlayer(),"Invalid Target: [BOSS].");
					return false;
				}
				
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 10);
				if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
					PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
					return false;
				}

				((Damageable)target).setHealth(0);
				return true;
				//Spell: Banish.
			}
			//Void Climate.
		}
		PrintUtils.sendMessage(event.getPlayer(),"Fizzle!");
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
//TODO Make Solar Expansion a spell.
//if(event.getAction().equals(Action.RIGHT_CLICK_AIR)) 
//{
//	if (event.getPlayer().getNearbyEntities(7, 7, 7).size() == 0)
//	{
//		PrintUtils.sendMessage(event.getPlayer(),"Invalid Target.");
//		return false;
//	}
//	
//	PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - 15);
//	if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()<PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana()) 
//	{
//		PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMinMana());
//		PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
//		return false;
//	}
//	
//	for (Entity target0 : event.getPlayer().getNearbyEntities(7, 7, 7)) 
//	{
//		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_AMBIENT, SoundCategory.MASTER, 1, 1);
//		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_BLAZE_SHOOT, SoundCategory.MASTER, 1, 1);
//		
//		target0.setVelocity(target0.getLocation().toVector().subtract(event.getPlayer().getLocation().toVector()));
//		target0.setFireTicks(200);	
//	}
//	//Spell Solar Expansion.
//	return true; 
//}