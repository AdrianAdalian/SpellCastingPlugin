package spellcasting;

import org.bukkit.Bukkit;
import org.bukkit.Material;

import com.yukiemeralis.blogspot.zenith.module.ZenithModule;
import com.yukiemeralis.blogspot.zenith.module.ZenithModule.ModInfo;
import com.yukiemeralis.blogspot.zenith.module.java.annotations.Branch;
import com.yukiemeralis.blogspot.zenith.module.java.enums.BranchType;
import com.yukiemeralis.blogspot.zenith.utils.FileUtils;

import spellcasting.relics.recipe.RelicRecipe_CrystalShard;
import spellcasting.relics.recipe.RelicRecipe_DaoCharm;
import spellcasting.relics.recipe.RelicRecipe_DragonsAshes;
import spellcasting.relics.recipe.RelicRecipe_DynamiteCharge;
import spellcasting.relics.recipe.RelicRecipe_GalvanicNeedle;
import spellcasting.relics.recipe.RelicRecipe_HealingTear;
import spellcasting.relics.recipe.RelicRecipe_MagicArrow;
import spellcasting.relics.recipe.RelicRecipe_NaturesGift;
import spellcasting.relics.recipe.RelicRecipe_NaturesWrath;
import spellcasting.relics.recipe.RelicRecipe_NautilusCharm;
import spellcasting.relics.recipe.RelicRecipe_RiftTalisman;
import spellcasting.relics.recipe.RelicRecipe_SkullOfKnight;
import spellcasting.relics.recipe.RelicRecipe_WeatherCharm;
import spellcasting.relics.recipe.RelicRecipe_WitheringRose;
import spellcasting.spells.recipe.ItemRecipe_ManaPotion;
import spellcasting.spells.recipe.SpellRecipe_BookOfFire;
import spellcasting.spells.recipe.SpellRecipe_BookOfGeo;
import spellcasting.spells.recipe.SpellRecipe_BookOfHoly;
import spellcasting.spells.recipe.SpellRecipe_BookOfStorm;
import spellcasting.spells.recipe.SpellRecipe_BookOfUnholy;
import spellcasting.spells.recipe.SpellRecipe_BookOfVoid;
import spellcasting.spells.recipe.SpellRecipe_BookOfWater;

@Branch(BranchType.BETA)
//Adds safety measures respective to release type.
@ModInfo
(

		description = "A spell casting system. Current loaded spells: 90", 
		maintainer = "AdrianAdalian", 
		modIcon = Material.NETHER_STAR, 
		modName = "SpellCasting", 
		version = "1.0.0_b"
		,
		supportedApiVersions = {"v1_17_R1"}

)

public class Spells extends ZenithModule 
{

	@Override
	public void onDisable() 
	{
		
		Bukkit.getOnlinePlayers().stream().forEach(v -> v.kickPlayer("The server has closed."));
		
	}

	@Override
	public void onEnable() 
	{
		
		FileUtils.ensureFolder("./plugins/Spellcasting/data/");
		
		SpellRecipe_BookOfStorm.Init(); 
		SpellRecipe_BookOfStorm.Register();
		
		SpellRecipe_BookOfFire.Init();
		SpellRecipe_BookOfFire.Register();
		
		SpellRecipe_BookOfUnholy.Init();
		SpellRecipe_BookOfUnholy.Register();
		
		SpellRecipe_BookOfGeo.Init();
		SpellRecipe_BookOfGeo.Register();
		
		SpellRecipe_BookOfHoly.Init();
		SpellRecipe_BookOfHoly.Register();
		
		SpellRecipe_BookOfWater.Init();
		SpellRecipe_BookOfWater.Register();
		
		SpellRecipe_BookOfVoid.Init();
		SpellRecipe_BookOfVoid.Register();
		
		ItemRecipe_ManaPotion.Init();
		ItemRecipe_ManaPotion.Register();
		
		RelicRecipe_RiftTalisman.Init();
		RelicRecipe_RiftTalisman.Register();
		
		RelicRecipe_GalvanicNeedle.Init();
		RelicRecipe_GalvanicNeedle.Register();
		
		RelicRecipe_HealingTear.Init();
		RelicRecipe_HealingTear.Register();
		
		RelicRecipe_MagicArrow.Init();
		RelicRecipe_MagicArrow.Register();
		
		RelicRecipe_NaturesWrath.Init();
		RelicRecipe_NaturesWrath.Register();
		
		RelicRecipe_NaturesGift.Init();
		RelicRecipe_NaturesGift.Register();
		
		RelicRecipe_DragonsAshes.Init();
		RelicRecipe_DragonsAshes.Register();
		
		RelicRecipe_DynamiteCharge.Init();
		RelicRecipe_DynamiteCharge.Register();
		
		RelicRecipe_SkullOfKnight.Init();
		RelicRecipe_SkullOfKnight.Register();
		
		RelicRecipe_WitheringRose.Init();
		RelicRecipe_WitheringRose.Register();
		
		RelicRecipe_CrystalShard.Init();
		RelicRecipe_CrystalShard.Register();
		
		RelicRecipe_NautilusCharm.Init();
		RelicRecipe_NautilusCharm.Register();
		
		RelicRecipe_DaoCharm.Init();
		RelicRecipe_DaoCharm.Register();
		
		RelicRecipe_WeatherCharm.Init();
		RelicRecipe_WeatherCharm.Register();
		
	}
}

//TODO Add sounds to items that have yet to be assigned.
//TODO Spell books are book and quil items with their respective element.
//TODO Each spell has a mana cost.
//TODO Each spell costs 30 EXP to unlock, except a basic spell that all element users have access to 
			//(i.e. Fireball, smite, Geomorph, riptide, Expanding Force, and Damaging force for Fire, Storm, Geo, Water, Holy, and Unholy schools respectively.)
//TODO Each "tome" spell is a spell that modifies the book and quil into that respective item, disengaging tome spells are the same for engaging/disengaging any other type of spell.
//TODO Relic items are magic items that are *CRAFTED* and do not use mana, they are free to be used indefinitely but do require a nether star and other materials to be crafted.
//TODO 
//TODO Relic for water infinitely passively regenerates mana; 1 mana per sec. Is togglable.
//TODO Mana potions : crafting recipe: bottle of water and Lapiz Lazuli
//TODO Relic for Unholy: Relic: Withering flower. Causes the target entity to wither away.

//TODO Spell for unholy: Mana Equilibrium: Use life to regen mana. Is togglable, and is an outgoing spell.
//TODO Spell for holy: Life Equilibrium: Use mana to regen life. Is togglable, and is an outgoing spell.

//TODO Spell for holy: Pacify: Pacifies agro entity.

//PrintUtils.log(event.getAction().name() , InfoType.INFO) ; 


/*new BukkitRunnable()
{
  @Override
  public void run()
  {

  }
}.runTaskLater(Zenith.getInstance, 20*i);
*/

//Console PsWd
//!ch4nge_m3-Plea5e_[{]}#@!

//TODO spells are taking up mana even if there was no cast.
