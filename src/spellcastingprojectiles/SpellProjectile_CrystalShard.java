package spellcastingprojectiles;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.yukiemeralis.blogspot.zenith.specialprojectile.ProjectileFlag;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.EntityDetonator;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.LifeExpiredDetonator;

public class SpellProjectile_CrystalShard extends ZenithProjectile implements EntityDetonator, LifeExpiredDetonator
{
	
	public SpellProjectile_CrystalShard()
	{
		super(Arrow.class, 10, ProjectileFlag.INVISIBLE,ProjectileFlag.NO_GRAVITY,ProjectileFlag.DESTROY_ON_COLLISION);
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
		((Damageable) event.getEntity()).damage(6, getRealProjectile());
		
		if (event.getEntity() instanceof LivingEntity)
    	{
    		((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1));
    	}
	}
}
