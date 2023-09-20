package coffeeshop;

import java.util.List;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CoffeeShop {

	List<Product> products = new ArrayList<>();

	List<Product> order = new ArrayList<>();

	Scanner input = new Scanner(System.in);

	public void setupProducts() {
		Product coffee = new Product();
		coffee.setName("Coffee");
		coffee.setPrice(5.44);
		products.add(coffee);

		Product tea = new Product();
		tea.setName("Tea");
		tea.setPrice(4.33);
		products.add(tea);

		Product cookie = new Product();
		cookie.setName("Cookie");
		cookie.setPrice(6.77);
		products.add(cookie);

		Product sandwich = new Product();
		sandwich.setName("Egg & Cheese Muffin");
		sandwich.setPrice(19.99);
		products.add(sandwich);

	}

	public void printProduct(Product product) {
		// TODO HOMEWORK: Change this print only the product name + tab + price, use a $
		// in the price and try to align
		// ASK: how to justify output text right?
		DecimalFormat nice = new DecimalFormat("$#,###.00");
		System.out.println(product.getName() + "\t\t" + nice.format(product.getPrice()));
	}

	public void printAllProducts() {
		for (Product product : products) {
			printProduct(product);
		}
	}
	
	public void printOrder() {
		for (Product product : order) {
			System.out.println(product.getName());
		}
	}

	

	public int displayMainUserMenu() {
		System.out.println("1) Print the menu items and prices");
		System.out.println("2) Add an item to your order");
		System.out.println("3) Print the items in your order");
		System.out.println("4) Checkout");
		System.out.println("5) Exit");

		System.out.println("\nWhat do you want to do?");
		int select = input.nextInt();
		input.nextLine();

		return select;
	}

	public void userSelectProduct() {
		System.out.println("Enter product name to order: ");
		String orderSelection = input.nextLine();

		for (Product product : products) {
			if (product.getName().equalsIgnoreCase(orderSelection)) {
				order.add(product);
				System.out.println("Added " + product.getName() + " to your order.");
			}
		}
	}
	
	public void example() {
		double coffee = 5.44d;
		double tea = 4.33d;
		double cookie = 6.73d;
		double subtotal;
		double totalSale;
		final double SALES_TAX = 0.07;

		subtotal = (3 * coffee) + (4 * tea) + (2 * cookie);
		totalSale = subtotal += (subtotal * SALES_TAX);
		DecimalFormat df = new DecimalFormat("$#,##0.00");
		System.out.println("Subtotal:\t" + df.format(subtotal));
		System.out.println("Tax:\t\t" + df.format(subtotal * SALES_TAX));
		System.out.println("Total:\t\t" + df.format(totalSale));
	}

	public static void main(String[] args) {

		CoffeeShop cf = new CoffeeShop();
		cf.setupProducts();
		while (true) {
			int userSelection = cf.displayMainUserMenu();
			if (userSelection == 1) {
				cf.printAllProducts();
			} else if (userSelection == 2) {
				cf.userSelectProduct();
			} else if (userSelection == 3) {
				cf.printOrder();
			}
			else if (userSelection == 5) {
				System.exit(0);
			} else {
				System.out.println("User input " + userSelection + " is unknown.  Try again.");
			}

		}

	}

}
