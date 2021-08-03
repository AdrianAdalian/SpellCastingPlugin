package spellcasting.spells.summons;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class BaseSummonedCreature 
{
	
	protected Player summoner ;
	protected LivingEntity summonedcreature ;
	
	public BaseSummonedCreature(Player summoner , LivingEntity summonedcreature) 
	{
		this.summonedcreature = summonedcreature;
		this.summoner = summoner;
	}
	
	public LivingEntity summonedcreature()
	{
		return summonedcreature;
	}
	
	public Player summoner() {
		return summoner;
	}
	
	static Map<LivingEntity, BaseSummonedCreature> creature_registry = new HashMap<>();
	
	public static Map<LivingEntity, BaseSummonedCreature> getSummonedCreature()
	{
		return creature_registry;
	}
}
