package spellcasting;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener ;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent ;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import com.yukiemeralis.blogspot.zenith.utils.ItemUtils;
import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.nightside.mana.PlayerDataMap;
import spellcasting.nightside.mana.SpellManaInterface;
import spellcasting.registered.gui.SpellGUI_Fire;
import spellcasting.registered.gui.SpellGUI_Geo;
import spellcasting.registered.gui.SpellGUI_Holy;
import spellcasting.registered.gui.SpellGUI_Storm;
import spellcasting.registered.gui.SpellGUI_Unholy;
import spellcasting.registered.gui.SpellGUI_Void;
import spellcasting.registered.gui.SpellGUI_Water;
import spellcasting.spells.BaseSpell;
import spellcasting.spells.element_void.SpellAccelerate;
import spellcasting.spells.element_void.SpellAntimatter;
import spellcasting.spells.element_void.SpellCataclysm;
import spellcasting.spells.element_void.SpellDaoCharm;
import spellcasting.spells.element_void.SpellEtherContinuity;
import spellcasting.spells.element_void.SpellLevitate;
import spellcasting.spells.element_void.SpellMatterReversal;
import spellcasting.spells.element_void.SpellNullPointConfiguration;
import spellcasting.spells.element_void.SpellRiftPortalization;
import spellcasting.spells.element_void.SpellTelekinesis;
import spellcasting.spells.element_void.SpellVoidBolt;
import spellcasting.spells.element_void.SpellVoidPearl;
import spellcasting.spells.element_void.SpellVoidShift;
import spellcasting.spells.element_void.SpellWeatherCharm;
import spellcasting.spells.fire.SpellDragonAshes;
import spellcasting.spells.fire.SpellDynamiteCharge;
import spellcasting.spells.fire.SpellFireBall;
import spellcasting.spells.fire.SpellFlameAura;
import spellcasting.spells.fire.SpellFlamethrower;
import spellcasting.spells.fire.SpellHeatWave;
import spellcasting.spells.fire.SpellIgnite;
import spellcasting.spells.fire.SpellIgnitionDrive;
import spellcasting.spells.fire.SpellInsulationPowder;
import spellcasting.spells.fire.SpellKindleFlame;
import spellcasting.spells.fire.SpellMeteor;
import spellcasting.spells.fire.SpellOverclockProtocol;
import spellcasting.spells.fire.SpellSmokeScreen;
import spellcasting.spells.fire.SpellSolGate;
import spellcasting.spells.geo.SpellBoulder;
import spellcasting.spells.geo.SpellDracoMorph;
import spellcasting.spells.geo.SpellEarthquake;
import spellcasting.spells.geo.SpellGeoMorph;
import spellcasting.spells.geo.SpellGravitas;
import spellcasting.spells.geo.SpellInscribeLuck;
import spellcasting.spells.geo.SpellMageMorph;
import spellcasting.spells.geo.SpellMetalMorph;
import spellcasting.spells.geo.SpellNaturesGift;
import spellcasting.spells.geo.SpellNaturesWrath;
import spellcasting.spells.geo.SpellPebbles;
import spellcasting.spells.geo.SpellPoisonDart;
import spellcasting.spells.geo.SpellPoisonGas;
import spellcasting.spells.geo.SpellTransmute;
import spellcasting.spells.holy.SpellAccolades;
import spellcasting.spells.holy.SpellAngelicFlight;
import spellcasting.spells.holy.SpellBarrier;
import spellcasting.spells.holy.SpellExpandingForce;
import spellcasting.spells.holy.SpellExtricate;
import spellcasting.spells.holy.SpellGuardianAngel;
import spellcasting.spells.holy.SpellHeal;
import spellcasting.spells.holy.SpellJudgement;
import spellcasting.spells.holy.SpellMagicArrow;
import spellcasting.spells.holy.SpellNosferatu;
import spellcasting.spells.holy.SpellRadiance;
import spellcasting.spells.holy.SpellRejuvenation;
import spellcasting.spells.holy.SpellRepentance;
import spellcasting.spells.holy.SpellSatiate;
import spellcasting.spells.storm.SpellBlink;
import spellcasting.spells.storm.SpellGaleForce;
import spellcasting.spells.storm.SpellGalvanicNeedle;
import spellcasting.spells.storm.SpellGust;
import spellcasting.spells.storm.SpellHealingCurrent;
import spellcasting.spells.storm.SpellLightningStorm;
import spellcasting.spells.storm.SpellRiftTalisman;
import spellcasting.spells.storm.SpellSmite;
import spellcasting.spells.storm.SpellStaticCharge;
import spellcasting.spells.storm.SpellTailWind;
import spellcasting.spells.storm.SpellTeleport;
import spellcasting.spells.storm.SpellThunderStrike;
import spellcasting.spells.storm.SpellVaporize;
import spellcasting.spells.storm.SpellWildBolt;
import spellcasting.spells.unholy.SpellBlindingDust;
import spellcasting.spells.unholy.SpellDamagingForce;
import spellcasting.spells.unholy.SpellDebilitate;
import spellcasting.spells.unholy.SpellDecompose;
import spellcasting.spells.unholy.SpellDefile;
import spellcasting.spells.unholy.SpellDemonSight;
import spellcasting.spells.unholy.SpellDemonicReflexes;
import spellcasting.spells.unholy.SpellLifeSteal;
import spellcasting.spells.unholy.SpellLightShift;
import spellcasting.spells.unholy.SpellRaiseDead;
import spellcasting.spells.unholy.SpellReapSouls;
import spellcasting.spells.unholy.SpellSkullOfNight;
import spellcasting.spells.unholy.SpellStormSurge;
import spellcasting.spells.unholy.SpellWitheringRose;
import spellcasting.spells.water.SpellCrystalShard;
import spellcasting.spells.water.SpellCrystalize;
import spellcasting.spells.water.SpellFishScales;
import spellcasting.spells.water.SpellGills;
import spellcasting.spells.water.SpellManaBurn;
import spellcasting.spells.water.SpellNautilusCharm;
import spellcasting.spells.water.SpellPoseidonsGift;
import spellcasting.spells.water.SpellRagingCurrent;
import spellcasting.spells.water.SpellRipTide;
import spellcasting.spells.water.SpellSaturate;
import spellcasting.spells.water.SpellSuffocate;
import spellcasting.spells.water.SpellTidalForce;
import spellcasting.spells.water.SpellTidalWave;
import spellcasting.spells.water.SpellWaterLash;

public class CastListener implements Listener
{
	
	@SuppressWarnings("serial")
	static Map<String, BaseSpell> spell_registry = new HashMap<>()
	{{
	  
	  put("SpellFireBall", new SpellFireBall()); //1
	  put("SpellMagicArrow", new SpellMagicArrow()); //2
	  put("SpellHeal", new SpellHeal()); //3
	  put("SpellSmite", new SpellSmite()); //4
	  put("SpellBlink", new SpellBlink()); //5
	  
	  put("SpellExpandingForce", new SpellExpandingForce()); //6
	  put("SpellDamagingForce", new SpellDamagingForce()); //7
	  
	  put("SpellGust", new SpellGust()); //8
	  put("SpellGaleForce", new SpellGaleForce()); //9
	  put("SpellGeoMorph", new SpellGeoMorph()); //10
	  
	  put("SpellRipTide", new SpellRipTide()); //11
	  put("SpellTeleport", new SpellTeleport()); //12
	  put("SpellThunderStrike", new SpellThunderStrike()); //13
	  put("SpellHealingCurrent", new SpellHealingCurrent()); //14
	  put("SpellVaporize", new SpellVaporize()); //15
	  put("SpellRiftTalisman", new SpellRiftTalisman()); //16
	  put("SpellTidalForce", new SpellTidalForce()); //17
	  put("SpellLightningStorm", new SpellLightningStorm()); //18
	  
	  put("SpellStormSurge", new SpellStormSurge()); //19 
	  put("SpellTailWind", new SpellTailWind()); //20 
	  put("SpellStaticCharge", new SpellStaticCharge()); //21 
	  put("SpellGuardianAngel", new SpellGuardianAngel()); //22 
	  put("SpellWildBolt", new SpellWildBolt()); //23 
	 
	  put("SpellLightShift", new SpellLightShift()); //24 
	  put("SpellDemonSight", new SpellDemonSight()); //25 
	  put("SpellDemonicReflexes", new SpellDemonicReflexes()); //26 
	  put("SpellSkullOfNight", new SpellSkullOfNight()); //27 
	  put("SpellDebilitate", new SpellDebilitate()); //28 
	  
	  put("SpellGalvanicNeedle", new SpellGalvanicNeedle()); //29 
	  
	  put("SpellMetalMorph", new SpellMetalMorph()); //30 
	  put("SpellMageMorph", new SpellMageMorph()); //31 
	  put("SpellDracoMorph", new SpellDracoMorph()); //32 
	  put("SpellGravitas", new SpellGravitas()); //33 
	  
	  put("SpellWitheringRose", new SpellWitheringRose()); //34 
	  put("SpellNaturesGift", new SpellNaturesGift()); //35 
	  put("SpellNaturesWrath", new SpellNaturesWrath()); // 36 
	  put("SpellNautilusCharm", new SpellNautilusCharm()); //37 
	  put("SpellGills", new SpellGills()); //38 
	  put("SpellRagingCurrent", new SpellRagingCurrent()); //39 
	  put("SpellCrystalShard", new SpellCrystalShard()); //40 
	  put("SpellInscribeLuck", new SpellInscribeLuck()); //41 
	  
	  put("SpellPoisonDart", new SpellPoisonDart()); //42 
	  put("SpellPoisonGas", new SpellPoisonGas()); //43 
	  
	  put("SpellIgnite", new SpellIgnite()); //44
	  put("SpellIgnitionDrive", new SpellIgnitionDrive()); //45
	  put("SpellKindleFlame", new SpellKindleFlame()); //46
	  put("SpellOverclockProtocol", new SpellOverclockProtocol()); //47
	  put("SpellHeatWave", new SpellHeatWave()); //48
	  put("SpellSolGate", new SpellSolGate()); //49
	  put("SpellDragonAshes", new SpellDragonAshes()); //50
	  put("SpellSmokeScreen", new SpellSmokeScreen()); //51
	  put("SpellInsulationPowder", new SpellInsulationPowder()); //52
	  put("SpellFlamethrower", new SpellFlamethrower()); //53
	  put("SpellFlameAura", new SpellFlameAura()); //54
	  
	  put("SpellDynamiteCharge", new SpellDynamiteCharge()); //55
	  put("SpellMeteor", new SpellMeteor()); //56
	  
	  put("SpellRadiance", new SpellRadiance()); //57
	  put("SpellRejuvenation", new SpellRejuvenation()); //58
	  put("SpellLifeSteal", new SpellLifeSteal()); //59
	  put("SpellJudgement", new SpellJudgement()); //60
	  put("SpellDefile", new SpellDefile()); //61
	  put("SpellBlindingDust", new SpellBlindingDust()); //62
	  put("SpellRepentance", new SpellRepentance()); //63
	  
	  put("SpellDecompose", new SpellDecompose()); //64
	  put("SpellReapSouls", new SpellReapSouls()); //65
	  put("SpellRaiseDead", new SpellRaiseDead()); //66
	  
	  put("SpellTransmute", new SpellTransmute()); //67
	  put("SpellBoulder", new SpellBoulder()); //68
	  put("SpellPebbles", new SpellPebbles()); //69
	  put("SpellEarthquake", new SpellEarthquake()); //70
	  put("SpellSatiate", new SpellSatiate()); //71
	  put("SpellExtricate", new SpellExtricate()); //72
	  put("SpellBarrier", new SpellBarrier()); //73
	  
	  put("SpellAccolades", new SpellAccolades()); //74
	  put("SpellAngelicFlight", new SpellAngelicFlight()); //75
	  put("SpellNosferatu", new SpellNosferatu()); //76
	  
	  put("SpellWaterLash", new SpellWaterLash()); //77
	  put("SpellTidalWave", new SpellTidalWave()); //78
	  put("SpellSuffocate", new SpellSuffocate()); //79
	  put("SpellPoseidonsGift", new SpellPoseidonsGift()); //80
	  put("SpellFishScales", new SpellFishScales()); //81
	  put("SpellCrystalize", new SpellCrystalize()); //82
	  put("SpellSaturate", new SpellSaturate()); //83
	  put("SpellManaBurn", new SpellManaBurn()); //84
	  
	  put("SpellDaoCharm", new SpellDaoCharm()); //1.A (85)
	  put("SpellWeatherCharm", new SpellWeatherCharm()); //2.A (86)
	  put("SpellLevitate", new SpellLevitate()); //3.A (87)
	  put("SpellVoidShift", new SpellVoidShift()); //4.A (89)
	  put("SpellTelekinesis", new SpellTelekinesis()); //5.A (90)
	  put("SpellVoidPearl", new SpellVoidPearl()); //5.A (91)
	  put("SpellNullPointConfiguration", new SpellNullPointConfiguration()); //6.A (92)
	  put("SpellEtherContinuity", new SpellEtherContinuity()); //7.A (93)
	  
	  put("SpellMatterReversal", new SpellMatterReversal()); //8.A (94)
	  put("SpellVoidBolt", new SpellVoidBolt()); //9.A(95)
	  put("SpellRiftPortalization", new SpellRiftPortalization()); //10.A (96)
	  put("SpellAccelerate", new SpellAccelerate()); //11.A (97)
	  put("SpellAntimatter", new SpellAntimatter()); //12.A (98)
	  put("SpellCataclysm", new SpellCataclysm()); //13.A (99)
	  
	  
	}};
	
	@EventHandler
	
	public void onCast(PlayerInteractEvent event) 
	{
		
		ItemStack held;
		held = event.getPlayer().getInventory().getItem(EquipmentSlot.HAND) ;
		if(held==null || held.getType().equals(Material.AIR))
		{
			return ;
		}
		if(ItemUtils.hasNamespacedKey(held, "spellname")) 
		{
			event.setCancelled(true);
			
			String spell = ItemUtils.readFromNamespacedKey(held, "spellname");
			
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()>=spell_registry.get(spell).getManaCost()) 
			{
				if(spell_registry.get(spell).cast(event)) 
				{
					PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() - spell_registry.get(spell).getManaCost());
					SpellManaInterface.updateScoreBoard(event.getPlayer());
				}
				return;
			}
			
			PrintUtils.sendMessage(event.getPlayer(), "Mana Insufficient.");
			
			return;
		}
		
		if (ItemUtils.hasNamespacedKey(held, "SpellBookStormID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Storm gui = new SpellGUI_Storm();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookFireID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Fire gui = new SpellGUI_Fire();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookUnholyID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Unholy gui = new SpellGUI_Unholy();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookGeoID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Geo gui = new SpellGUI_Geo();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookHolyID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Holy gui = new SpellGUI_Holy();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookWaterID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Water gui = new SpellGUI_Water();
			gui.init();
			gui.display(event.getPlayer());
		}
		if (ItemUtils.hasNamespacedKey(held, "SpellBookVoidID"))
		{
			if (!event.getAction().equals(Action.RIGHT_CLICK_AIR))
			{
				return;
			}	
			event.setCancelled(true);
			SpellGUI_Void gui = new SpellGUI_Void();
			gui.init();
			gui.display(event.getPlayer());
		}
	}
	@EventHandler
	public void onItemConsume(PlayerItemConsumeEvent event)
	{
		if (ItemUtils.hasNamespacedKey(event.getItem(), "ManaPotionID")) 
		{	
			
			PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana() + 50);
			if (PlayerDataMap.getPlayerData(event.getPlayer()).getCurrentMana()>PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana()) 
			{
				PlayerDataMap.getPlayerData(event.getPlayer()).setCurrentMana(PlayerDataMap.getPlayerData(event.getPlayer()).getMaxMana());
			}
			SpellManaInterface.updateScoreBoard(event.getPlayer());
			return;
		}
	}
}
