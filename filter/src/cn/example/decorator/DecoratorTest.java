package cn.example.decorator;

import org.junit.Test;

public class DecoratorTest {
	@Test
	public void testDecorator() {
		IHuman person = new Person();
		Decorator decorator = new Decorator_zero(new Decorator_one(person));
		decorator.wearClothes();
		decorator.walkToWhere();
	}
}
