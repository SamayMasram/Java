package com.dkte.quiz.service;

import java.util.Scanner;

public class AdminService {
	public static int adminMenuOptions(Scanner sc) {
		System.out.println("0. Logout");
		System.out.println("1. Create Quiz");
		System.out.println("2. List Quiz");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	public static void adminMenu(Scanner sc) {
		int choice;
		while ((choice = adminMenuOptions(sc)) != 0) {
			switch(choice) {
			case 1:
				System.out.println("Quiz Created");
				break;
			case 2:
				System.out.println("List Quiz");
				break;
			default:
				System.out.println("Wrong Choice. Try Again.");
				break;
			}
		}
	}
}
