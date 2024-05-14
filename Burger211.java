package Burger_Project.Burger_Project;

import java.util.*;

public abstract class Burger211 {

	private static HashMap<Integer, BurgerInfo> burger = new HashMap<>();

	Burger211() {

		burger.put(1, new BurgerInfo("Inheritance Burger", 4.5, "beef patty, tomato, onion, black olive, ranch sauce"));
		burger.put(2, new BurgerInfo("@Override Burger", 5.5, "beef patty, lime, onion, lettuce, tomato sauce"));
		burger.put(3, new BurgerInfo("Polymorphism Burger", 6.5, "chicken breast, gallo, onion, ranch sauce"));
	}

	abstract void printMenu();

	public String getName(int i) {
		return burger.get(i).name;
	}

	public double getPrice(int i) {
		return burger.get(i).price;
	}

	public String getTopping(int i) {
		return burger.get(i).topping;
	}


	public void updateTopping(int i, String newTopping) {
		burger.get(i).topping = newTopping;
	}
	
	public int getHowManyBurgers() {
		return burger.size();
	}
}
