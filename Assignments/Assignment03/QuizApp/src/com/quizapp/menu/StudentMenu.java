package com.quizapp.menu;

import java.util.Scanner;

public class StudentMenu {
	private static int studentMenuOptions(Scanner sc) {
		System.out.println("0. LogOut");
		System.out.println("1. View Quizes");
		System.out.println("2. Take Quiz");
		System.out.println("3. View Score");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	public static void studentMenu(Scanner sc) {
		int choice;
		while ((choice = studentMenuOptions(sc)) != 0) {
			switch(choice) {
			case 0:
				System.out.println("Logging Out");
				break;
			case 1:
				System.out.println("view quiz");
				break;
			case 2:
				System.out.println("take quiz");
				break;
			case 3:
				System.out.println("view score");
				break;
			default:
				System.out.println("Wrong Choice. Try Again.");
				break;
			}
		}
	}
}
