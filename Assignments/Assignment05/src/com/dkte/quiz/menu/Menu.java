package com.dkte.quiz.menu;

import java.util.Scanner;

import com.dkte.quiz.service.StudentService;

public class Menu {
	private static StudentService studentService = new StudentService();
	
	public static int menuOptions(Scanner sc) {
		System.out.println("0. Exit");
		System.out.println("1. Display All Students");
		System.out.println("2. Add Student");
		System.out.println("3. Update Student Course");
		System.out.println("4. Delete Student");
		System.out.print("Enter your choice: ");
		return sc.nextInt();
	}
	
	public static void menu(Scanner sc) {
		int choice;
		while((choice = menuOptions(sc)) != 0) {
			switch(choice) {
			case 1:
				studentService.displayStudents();
				break;				
			case 2:
				studentService.addStudent(sc);
				break;
			case 3:
				studentService.editStudent(sc);
				break;
			case 4:
				studentService.removeStudent(sc);
				break;
			default:
				System.out.println("Wrong Option");
				break;
			}
		}
	}
}
