package com.quizapp.menu;

import java.util.Scanner;

public class AdminMenu {
	private static int adminMenuOptions(Scanner sc) {
		System.out.println("0. LogOut");
		System.out.println("1. Create Quiz");
		System.out.println("2. List Quiz");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	public static void adminMenu(Scanner sc) {
		int choice;
		while ((choice = adminMenuOptions(sc)) != 0) {
			switch(choice) {
			case 0:
				System.out.println("Logging Out");
				break;
			case 1:
				System.out.println("create quiz");
				break;
			case 2:
				System.out.println("list quiz");
				break;
			default:
				System.out.println("Wrong Choice. Try Again.");
				break;
			}
		}
	}
}
