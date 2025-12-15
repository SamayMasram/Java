package com.quizapp.main;

import java.util.Scanner;
import com.quizapp.menu.MainMenu;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MainMenu.mainMenuWithEnum(sc);
		sc.close();
	}

}
