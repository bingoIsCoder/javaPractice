package cn.example.decorator;

public abstract class Decorator implements IHuman {
	private IHuman human;
	
	public Decorator(IHuman human) {
		this.human = human;
	}
	
	@Override
	public void wearClothes() {
		human.wearClothes();
	}

	@Override
	public void walkToWhere() {
		human.walkToWhere();
	}

}
