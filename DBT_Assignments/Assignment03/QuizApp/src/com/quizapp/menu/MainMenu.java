package com.quizapp.menu;

import java.util.Scanner;

enum  EMainMenu {
	Exit, StudentLogin, StudentRegister, AdminLogin
}

public class MainMenu {
	public static void mainMenuWithEnum(Scanner sc) {
		EMainMenu[] arr = EMainMenu.values();
		EMainMenu enumChoice;
		do {
			for (EMainMenu ele : arr)
				System.out.println(ele.ordinal()+". "+ele.name());
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			enumChoice = arr[choice];
			switch (enumChoice) {
			case Exit:
				System.out.println("Signing Out");
				break;
			case StudentRegister:
				StudentMenu.studentMenu(sc);
				break;
			case AdminLogin:
				AdminMenu.adminMenu(sc);
				break;
			default:
				System.out.println("Wrong Choice. Try again.");
				break;
			}
		} while (enumChoice != EMainMenu.Exit);
 	}
	
}
