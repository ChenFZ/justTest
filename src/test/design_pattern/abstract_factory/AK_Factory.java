package test.design_pattern.abstract_factory;

public class AK_Factory implements Factory {
	
	@Override
	public Bullet productBullet() {
		return new AK_bullet();
	}
	
	@Override
	public Gun productGun() {
		// TODO Auto-generated method stub
		return new AK();
	}
}
