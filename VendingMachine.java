package com.testcode;

import java.util.*;

public class VendingMachine {

	public static void main(String[] args) {
		Scanner sc = new java.util.Scanner(System.in);
		String drink;
		int drinkPrice;
		System.out.println("Please select your drink: \n" + "A for Coke - 25 cents \n" + "B for Pepsi - 35 cents \n"
				+ "C for Soda - 45 cents \n" + "E to Exit");
		drink = sc.next();
		boolean again = true;
		while (again) {
			again = false;
			switch (drink) {
			case "A":
			case "a":
				System.out.println("You have selected Coke");
				drinkPrice = 25;
				System.out.println("Please pay " + drinkPrice + " cents");
				makePayment(drinkPrice);
				break;

			case "B":
			case "b":
				System.out.println("You have selected Pepsi");
				drinkPrice = 35;
				System.out.println("Please pay " + drinkPrice + " cents");
				makePayment(drinkPrice);
				break;

			case "C":
			case "c":
				System.out.println("You have selected Soda");
				drinkPrice = 45;
				System.out.println("Please pay " + drinkPrice + " cents");
				makePayment(drinkPrice);
				break;

			case "E":
			case "e":
				break;
			default:
				System.out.println("Please make a correct entry");
				drink = sc.next();
				again = true;

			}
		}
	}

	public static void makePayment(int drinkPrice) {
		System.out.println("Please insert coins in the denominations of 1, 5, 10 & 25");
		Scanner kb = new Scanner(System.in);
		int sum = 0;
		int coins = 0;
		int change = 0;
		do {
			coins = kb.nextInt();
			if (coins == 1 || coins == 5 || coins == 10 || coins == 25) {
				sum += coins;
				if (sum > drinkPrice) {
					change = sum - drinkPrice;
					break;
				}
				if (sum < drinkPrice) {
					System.out.println("Total paid" + sum + " cents. Please insert more coins.");
				}
			} else {
				System.out.println("Please insert correct denominations");

			}
		} while (sum != drinkPrice);
		System.out.println("Confirm oder: Y or N");
		Scanner co = new Scanner(System.in);
		String confirmOrder = co.next();
		switch (confirmOrder) {
		case "Y":
		case "y":
			if (change == 0) {
				System.out.println("Please collect your drink. Have a nice day");
			} else
				System.out.println("Please collect your drink and change of " + change + " cents. Have a nice day");
			break;
		case "N":
		case "n":
			System.out.println("Please collect your refund " + sum + " cents. Have a nice day");
			break;
		}
	}
}
