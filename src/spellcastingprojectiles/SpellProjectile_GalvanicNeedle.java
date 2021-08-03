package spellcastingprojectiles;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import com.yukiemeralis.blogspot.zenith.Zenith;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ProjectileFlag;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.EntityDetonator;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.LifeExpiredDetonator;

public class SpellProjectile_GalvanicNeedle extends ZenithProjectile implements EntityDetonator, LifeExpiredDetonator
{
	
	public SpellProjectile_GalvanicNeedle()
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
		
		((Damageable) event.getEntity()) .damage(1, getRealProjectile());
		
		 new BukkitRunnable()
		  {
		    @Override
		    public void run()
		    {
		    	event.getEntity().getWorld().strikeLightning(getRealProjectile().getLocation());
		    }
		  }.runTaskLater(Zenith.getInstance(), 10);
			//this is how you set a damage value within a cast projectile.
		  
	}

	

	/*@Override
	public void refreshEffect()
	{
		
		this.getRealProjectile().getWorld().spawnParticle(Particle.PORTAL, this.getRealProjectile().getLocation(), 2);
		
	}*/
	
}
