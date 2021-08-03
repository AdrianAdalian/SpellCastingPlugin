package spellcastingprojectiles;

import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.yukiemeralis.blogspot.zenith.specialprojectile.ProjectileFlag;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.EntityDetonator;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.LifeExpiredDetonator;

public class SpellProjectile_DynamiteCharge extends ZenithProjectile implements EntityDetonator, LifeExpiredDetonator
{

	public SpellProjectile_DynamiteCharge()
	{
		super(Arrow.class, 20, ProjectileFlag.DESTROY_ON_COLLISION);
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
		event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 5);
	}
}
