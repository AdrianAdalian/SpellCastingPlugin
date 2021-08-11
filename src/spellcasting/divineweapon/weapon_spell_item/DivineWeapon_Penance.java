package spellcasting.divineweapon.weapon_spell_item;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.yukiemeralis.blogspot.zenith.utils.ChatUtils;

import spellcasting.spells.BaseSpell;
import spellcastingprojectiles.DivineWeapon_Penance_Projectile;

public class DivineWeapon_Penance extends BaseSpell
{

	public DivineWeapon_Penance()
	{
		super(Material.BOW, ChatUtils.of("Magic Weapon: Penance", "FFE748","FFFFFF","§l§o"), 10, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fA longbow, blessed by those of §r§f§o§lHoly§r§f decent.","§r§fPrimary fire retains the function of a normal bow.","§r§fAbility: Saving Grace:","§r§f[Left Click] Fire a healing arrow at any target.","§r§aHeals§r§f 4 hearts over 10 seconds.","§r§fRange: 15 meters of alt fire.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if(event.getAction().equals(Action.LEFT_CLICK_AIR)) 
		{
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_ARROW_SHOOT, SoundCategory.MASTER, 1, 1);
			
			new DivineWeapon_Penance_Projectile().launch(event.getPlayer());
			return true;
		}
		return false;
	}
}

//event.setCancelled(false);

//ItemStack arrow = new ItemStack(Material.TIPPED_ARROW);
//PotionMeta Meta = (PotionMeta) arrow.getItemMeta();
//Meta.setBasePotionData(new PotionData(PotionType.REGEN));
//arrow.setItemMeta(Meta);
//arrow.setPickupStatus(PickupStatus.DISALLOWED);
//
//event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
//
//event.getPlayer().getInventory().setItemInOffHand(arrow);

