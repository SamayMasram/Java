package com.app.menu;

import java.util.Scanner;
import com.app.service.StudentService;

public class StudentMenu {
	static StudentService ss = new StudentService();
	public static int menuOption(Scanner sc) {
		System.out.println("\n=======Student_Menu=======");
		System.out.println("1.View Quizzes");
		System.out.println("2.Take Quiz");
		System.out.println("3.View Scores");
		System.out.println("4.Logout");
		System.out.print("Enter Your Choice: ");
		return sc.nextInt();
	}
	
	public static void studentMenu(Scanner sc) throws Exception {
		int choice = 0;
		while ((choice = menuOption(sc))!=4) {
			switch (choice) {
			case 1:
				StudentService.listQuizService();
				break;
			case 2:
				StudentService.takeQuizService(sc);
				break;
			case 3:
				StudentService.viewScore();
				break;
			case 4:
				System.out.println("Student Logged Out");
				break;
			default:
				System.out.println("Invalid choice !!!");
			}
		}
	}
}
