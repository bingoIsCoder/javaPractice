package cn.example.decorator;

public class Decorator_one extends Decorator {

	public Decorator_one(IHuman human) {
		super(human);
	}
	
	public void goClothespress() {
		System.out.println("go Clothespress");
	}
	
	public void findPlaceOnMap() {
		System.out.println("find place on map");
	}
	
	@Override
	public void wearClothes() {
		super.wearClothes();
		goClothespress();
	}
	
	@Override
	public void walkToWhere() {
		super.walkToWhere();
		findPlaceOnMap();
	}
}
