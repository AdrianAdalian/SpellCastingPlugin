package spellcasting.spells.fire;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.PrintUtils;

import spellcasting.Source_Particles;
import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.SpellProjectile_DynamiteCharge;

public class SpellDynamiteCharge extends BaseSpell
{

	public SpellDynamiteCharge()
	{
		super(Material.RED_CANDLE, "§r§e§ko§r§e§lRelic: §r§fDynamite Charge§r§e§ko§r", 20, true, "§r§fElement: §r§cFire§r§f.","§r§fAn old dynamite charge enchanted with §r§cFire§r§f magic.","§r§fCast a projectile that explodes upon impact.","§r§fRange: 20 meters.","§r§fMana cost: 20 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{

		if (!event.getAction().equals(Action.LEFT_CLICK_AIR))
		{
			PrintUtils.sendMessage(event.getPlayer(),"Invalid Cast Method.");
			return false;
		}
		
		event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_EGG_THROW, SoundCategory.MASTER, 1, 1);
		
		Source_Particles.drawDisc(event.getPlayer().getLocation(), 1, 1, 10, Particle.LAVA, null);
		
		new SpellProjectile_DynamiteCharge().launch(event.getPlayer());
		
		return true;
	}
}
