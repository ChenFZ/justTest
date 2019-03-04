package test.design_pattern.abstract_factory;

public class M4_Factory implements Factory {

	@Override
	public Bullet productBullet() {
		return new M4_bullet();
	}
	@Override
	public Gun productGun() {
		// TODO Auto-generated method stub
		return new M4();
	}
}
