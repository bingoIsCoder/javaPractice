package cn.example.decorator;

public class Decorator_zero extends Decorator {

	public Decorator_zero(IHuman human) {
		super(human);
	}
	
	public void goHome() {
		System.out.println("go home");
	}
	
	public void findMap() {
		System.out.println("find map");
	}
	
	@Override
	public void wearClothes() {
		super.wearClothes();
		goHome();
	}
	
	@Override
	public void walkToWhere() {
		super.walkToWhere();
		findMap();
	}
}
