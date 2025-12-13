package com.si2;

import java.util.Scanner;

public class Assignment02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter String: ");
		try {
			Strings line = new Strings();
			line.setLine(sc.nextLine());
			System.out.println("Entered String: " + line.toString());
			System.out.println("String Length: " +  line.getLength());
		}
		catch (ExceptionLineTooLongException e) {
			System.out.println("\nMessage: " + e.getMessage());
		}
		sc.close();
		
	}

}
