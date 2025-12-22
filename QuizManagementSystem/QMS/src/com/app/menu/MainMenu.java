package com.app.menu;

import java.util.Scanner;

import com.app.service.AdminService;
import com.app.service.StudentService;

public class MainMenu {
	public static AdminService as = new AdminService();
	public static StudentService ss = new StudentService();
	public static int menuOption(Scanner sc) {
		System.out.println("\n=======MAIN_MENU========");
		System.out.println("1.Admin Login");
		System.out.println("2.Student Registration");
		System.out.println("3.Student Login");
		System.out.println("4.Exit");
		System.out.print("Enter Your Choice: ");
		return sc.nextInt();
	}
	
	public static void mainMenu(Scanner sc ) {
		int choice = 0;
		while ((choice = menuOption(sc))!=4) {
			switch (choice) {
			case 1:
				as.adminLoginService(sc);
				break;
			case 2:
				ss.stuRegisterService(sc);
				break;
			case 3:
				ss.stuLoginService(sc);
				break;
			default:
				System.out.println("Invalid choice !!!");
			}
		}
	}
	
}
