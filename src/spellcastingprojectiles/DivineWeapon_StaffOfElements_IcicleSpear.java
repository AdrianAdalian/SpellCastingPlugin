package spellcastingprojectiles;

import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.yukiemeralis.blogspot.zenith.specialprojectile.ProjectileFlag;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.EntityDetonator;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.LifeExpiredDetonator;

public class DivineWeapon_StaffOfElements_IcicleSpear extends ZenithProjectile implements EntityDetonator, LifeExpiredDetonator
{
	
	public DivineWeapon_StaffOfElements_IcicleSpear()
	{
		super(Snowball.class, 15, ProjectileFlag.DESTROY_ON_COLLISION, ProjectileFlag.NULL_SHOOTER, ProjectileFlag.NO_GRAVITY);
	}
	@Override
	public void onExpire()
	{
		return ;	
	}
	@Override
	public void onEntityCollision(EntityDamageByEntityEvent event)
	{
		event.setCancelled(true);
		((Damageable) event.getEntity()).damage(2, getRealProjectile());
		
		if (event.getEntity() instanceof LivingEntity)
    	{
    		((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1));
    	}
	}
}
