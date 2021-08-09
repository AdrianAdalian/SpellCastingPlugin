package spellcasting.divineweapon.weapon_spell_item;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import com.yukiemeralis.blogspot.zenith.utils.ChatUtils;

import spellcasting.spells.BaseSpell;

public class DivineWeapon_Penance extends BaseSpell
{

	public DivineWeapon_Penance()
	{
		super(Material.BOW, ChatUtils.of("Magic Weapon: Penance", "FFE748","FFFFFF","§l§o"), 10, true, "§r§fElement: §r§f§o§lHoly§r§f.","§r§fA longbow, blessed by those of §r§f§o§lHoly§r§f decent.","§r§fPrimary fire requires basic arrows,","§r§fwhile a left click summons a healing arrow available until used.","§r§fMana cost: 10 §r§9mana§r§f.");
	}

	@Override
	public boolean cast(PlayerInteractEvent event)
	{
		if(!event.getAction().equals(Action.LEFT_CLICK_AIR)) 
		{
			return false;
		}
		
		ItemStack arrow = new ItemStack(Material.TIPPED_ARROW);
        PotionMeta Meta = (PotionMeta) arrow.getItemMeta();
        Meta.setBasePotionData(new PotionData(PotionType.REGEN));
        arrow.setItemMeta(Meta);
        
        event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ITEM_ARMOR_EQUIP_GENERIC, SoundCategory.MASTER, 1, 1);
        
		event.getPlayer().getInventory().setItemInOffHand(arrow);
		
		return true;
	}
}
