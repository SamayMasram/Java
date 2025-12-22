package com.app.service;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.Dao.AttemptDao;
import com.app.Dao.QuestionDao;
import com.app.Dao.QuizDao;
import com.app.Dao.StudentDao;
import com.app.entity.Attempts;
import com.app.entity.Question;
import com.app.entity.Quiz;
import com.app.menu.StudentMenu;

public class StudentService {
	private static StudentMenu sm = new StudentMenu();
	public void stuLoginService(Scanner sc) {
		String email, pass;
		System.out.print("Enter email -");
		email = sc.next();
		System.out.print("Enter pass -");
		pass = sc.next();
		String role ="Student";
		try (StudentDao ed = new StudentDao()) {
			if (ed.studentLogin(email, pass, role)) {
				sm.studentMenu(sc);
				System.out.print("Student Login Successfull...");
			} else {
				System.out.println("Student Login Failed !");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
	
	public void stuRegisterService(Scanner sc) {
		String name, email, pass;
		System.out.print("Enter Name -");
		name = sc.next();
		System.out.print("Enter Email -");
		email = sc.next();
		System.out.print("Enter Pass -");
		pass = sc.next();
		String role ="Student";
		try (StudentDao ed = new StudentDao()) {
			ed.studentRegister(name, email, pass , role); 
			System.out.println("Student Register Successfully...");
		} catch (SQLException e) {
			System.out.println("Student Registration Failed !");
			e.printStackTrace();
		} catch (Exception e1) {
			System.out.println("Student Registration Failed !");
			e1.printStackTrace();
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
	
	public static void takeQuizService(Scanner sc) {
		System.out.print("Enter Quiz ID: ");
		int qid = sc.nextInt();
		try (QuestionDao qd = new QuestionDao()){
			qd.getQuestion(qid);
			List<Question> queList = qd.getQuestion(qid);
			if(!queList.isEmpty()) {
				int score = 0;
				for(Question q : queList) {
					System.out.println("\n"+q.getText());
					System.out.println("A."+q.getA());
					System.out.println("B."+q.getB());
					System.out.println("C."+q.getC());
					System.out.println("D."+q.getD());
					System.out.print("Enter Your Answer: ");
					String ans = sc.next();
					ans = ans.toUpperCase();
					String coop = String.valueOf(q.getCorrect());
					if(ans.equals(coop)) {
						score++;
					}
				}
				AttemptDao at = new AttemptDao();
				at.insertAttempt(qid, StudentDao.stuId, score, queList.size());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void viewScore() {
		int uid = StudentDao.stuId; 
		try(AttemptDao adt = new AttemptDao()){
			List<Attempts> atList = adt.viewScore(uid);
			for(Attempts a : atList) {
				System.out.print("\nAttempt ID: "+a.getId());
				System.out.print("\tQuiz ID: "+a.getQuiz_id());
				System.out.print("\tScore: "+a.getScore());
				System.out.print("\tTotal Question: "+a.getTotal());
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
