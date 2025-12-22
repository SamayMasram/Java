package com.app.service;

import java.io.File;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.Dao.*;
import com.app.entity.*;
import com.app.menu.AdminMenu;
import com.app.util.QuestionFileParser;

public class AdminService {
	private static AdminMenu edm = new AdminMenu();
	// Admin login
	public static void adminLoginService(Scanner sc) {
		String email, pass;
		System.out.print("Enter email -");
		email = sc.next();
		System.out.print("Enter pass -");
		pass = sc.next();
		String role ="Admin";
		try (AdminDao ed = new AdminDao()) {
			if (ed.adminLogin(email, pass , role)) {
				System.out.print("Login Successfull...");
				edm.adminMenu(sc);
			} else {
				System.out.println("Login failed !");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	public static void addQuizService(Scanner sc, Integer adId) throws Exception {
		System.out.print("Enter Quiz Title: ");
		String title = sc.next();
		System.out.println("Enter Question File Path: ");
		String path = sc.next();
		File file = new File(path);
		Quiz quiz = new Quiz();
		quiz.setTitle(title); 
		quiz.setCreater_id(adId);
		try (QuizDao quizDao = new QuizDao()) {
			int quizId = quizDao.insert(quiz);
			List<Question> list = QuestionFileParser.parse(file);
					try (QuestionDao questionDao = new QuestionDao()) {
						for (Question q : list) {
							q.quiz_id = quizId;
							questionDao.insert(q); 	
						}
					}
					System.out.println("Quiz imported Successfully with id=" + quizId);
		}
	}	
	
	public static void createQuizService(Scanner sc) {
		System.out.print("Enter Title: ");
		String title = sc.next();
		System.out.print("Enter Creator ID: ");
		int creatorId = sc.nextInt();
		try (QuizDao qd = new QuizDao()) {
			qd.createQuiz(title, creatorId);
			System.out.println("Quiz Created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteService(Scanner sc) {		
		try (QuizDao qd = new QuizDao()) {
			System.out.print("Enter Quiz ID for Deletion: ");
			int qId = sc.nextInt();
			qd.removeQuiz(qId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void listQuizService() {
		try (QuizDao qDao = new QuizDao()) {
			List<Quiz> quizlist = qDao.getQuizList();
			for(Quiz q : quizlist ) {
				System.out.print("\nQuiz ID: " + q.getId());
				System.out.print("\tTitle: " + q.getTitle());
				System.out.print("\tCreator ID: " + q.getCreater_id());
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void viewScoresService() {
		try(AttemptDao adt = new AttemptDao()){
			List<Attempts> atList = adt.displayScore();
			for(Attempts a : atList) {
				System.out.print("\nAttempt ID: "+a.getId());
				System.out.print("\tQuiz ID: "+a.getQuiz_id());
				System.out.print("\tStudent ID: "+a.getStudent_id());
				System.out.print("\tScore: "+a.getScore());
				System.out.print("\tTotal Question: "+a.getTotal());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
