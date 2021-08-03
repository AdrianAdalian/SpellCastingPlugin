package spellcastingprojectiles;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.yukiemeralis.blogspot.zenith.specialprojectile.ProjectileFlag;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.EntityDetonator;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.LifeExpiredDetonator;

public class SpellProjectile_Pebbles  extends ZenithProjectile implements EntityDetonator, LifeExpiredDetonator
{
	public SpellProjectile_Pebbles()
	{
		super(Arrow.class, 5, ProjectileFlag.BOUNCY, ProjectileFlag.INVISIBLE, ProjectileFlag.DESTROY_ON_COLLISION);
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
	}
}
