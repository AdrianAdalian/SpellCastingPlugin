package spellcastingprojectiles;

import org.bukkit.Particle;
import org.bukkit.entity.Fireball;

import com.yukiemeralis.blogspot.zenith.specialprojectile.ParticleProjectile;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ProjectileFlag;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile;
import com.yukiemeralis.blogspot.zenith.specialprojectile.ZenithProjectile.LifeExpiredDetonator;

import spellcasting.Source_Particles;

public class SpellProjectile_BaseFireBall extends ZenithProjectile implements LifeExpiredDetonator, ParticleProjectile
{
	public SpellProjectile_BaseFireBall()
	{
		super(Fireball.class, 20, ProjectileFlag.INVISIBLE);
	}
	@Override
	public void onExpire()
	{
		this.getRealProjectile().remove();
	}
	@Override
	public void refreshEffect()
	{
		Source_Particles.drawSphere(this.getRealProjectile().getLocation(), 0.5, 1, 3, Particle.LAVA, null);
		Source_Particles.drawSphere(this.getRealProjectile().getLocation(), 0.5, 1, 3, Particle.SMOKE_NORMAL, null);
	}
}
