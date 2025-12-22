package com.app.menu;

import java.util.Scanner;

import com.app.Dao.AdminDao;
import com.app.service.AdminService;

public class AdminMenu {
	static AdminService as = new AdminService();
	public static int menuOption(Scanner sc) {
		System.out.println("\n=======Admin_Menu=======");
		System.out.println("1.Add Quiz");
		System.out.println("2.Update Quiz");
		System.out.println("3.Delete Quiz");
		System.out.println("4.List Quiz");
		System.out.println("5.View Scores");
		System.out.println("6.LogOut");
		System.out.print("Enter Your Choice: ");
		return sc.nextInt();
	}
	
	public static void adminMenu(Scanner sc) throws Exception {
		int choice = 0;
		while ((choice = menuOption(sc))!=6) {
			switch (choice) {
			case 1:
				AdminService.addQuizService(sc, AdminDao.adId);
				break;
			case 2:
				AdminService.createQuizService(sc);
				break;
			case 3:
				AdminService.deleteService(sc);
				break;
			case 4:
				AdminService.listQuizService();
				break;
			case 5:
				AdminService.viewScoresService();
				break;
			case 6:
				System.out.println("Admin Logged Out");
				break;
			default:
				System.out.println("Invalid choice !!!");
			}
		}
	}
}
