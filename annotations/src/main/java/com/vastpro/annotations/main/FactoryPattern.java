package com.vastpro.annotations.main;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;

public class FactoryPattern {
	public static void main(String[] args) throws Exception {
		ShoeShop seller = Container.getShoeShop();
		// "oops.LakhaniShoeFactory","oops.RamuShoeShop");
		Customer customer = new Customer();
		customer.name = "ramu";
		Shoe shoe = seller.sell(customer);
		System.out.println(shoe);
	}
}

class Container {
	public static ShoeShop getShoeShop() throws Exception {
		ShoeShop seller = new RamuShoeShop();
		// Class.forName(shopclassname).getConstructor().newInstance();
		Class c = seller.getClass();
		Class pclass = c.getSuperclass();
		Field field = pclass.getDeclaredField("factory");
		field.setAccessible(true);

		In in = field.getAnnotation(In.class);
		ShoeFactory factory = null;
		if (in != null) {
			String factoryclassname = in.factoryName();
			factory = (ShoeFactory) Class.forName(factoryclassname).getConstructor().newInstance();
		}

		// dependency injection

		seller.setFactory(factory);

		return seller;
	}
}

abstract class Shoe {

}

class SportsShoe extends Shoe {
}

class LeatherShoe extends Shoe {
}

interface Manufacturer {
	public Shoe make();
}

interface ShoeManufacturer extends Manufacturer {
	default public Shoe make() {
		return makeShoe();
	}

	public Shoe makeShoe();
}

interface Seller {
	public Shoe sell(Customer customer);
}

interface ShoeSeller extends Seller {
	default public Shoe sell(Customer customer) {
		return sellShoe(customer);
	}

	public Shoe sellShoe(Customer customer);
}

class Customer {
	String name;
}

abstract class ShoeFactory implements ShoeManufacturer {
	public ShoeFactory() {
		// TODO Auto-generated constructor stub
	}
}

class BataShoeFactory extends ShoeFactory {
	public BataShoeFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shoe makeShoe() {
		return new LeatherShoe();
	}
}

class LakhaniShoeFactory extends ShoeFactory {
	public LakhaniShoeFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shoe makeShoe() {
		return new SportsShoe();
	}
}

abstract class ShoeShop implements ShoeSeller {
	public ShoeShop() {
		// TODO Auto-generated constructor stub
	}

	@In(factoryName = "com.vastpro.annotations.main.LakhaniShoeFactory")
	private ShoeFactory factory;

	public void setFactory(ShoeFactory factory) {
		this.factory = factory;
	}

	public ShoeFactory getFactory() {
		return this.factory;
	}
}

class RamuShoeShop extends ShoeShop {
	public RamuShoeShop() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Shoe sellShoe(Customer customer) {
		// TODO Auto-generated method stub
		return getFactory().makeShoe();
	}
}

@Retention(RetentionPolicy.RUNTIME)
@interface In {
	String factoryName();
}
