package cn.example.decorator;

public class Person implements IHuman {

	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		System.out.println("wear what");
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		System.out.println("go where");
	}

}
