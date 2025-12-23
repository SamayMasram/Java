quizpackage com.dkte.quiz.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.dkte.quiz.dao.StudentDao;
import com.dkte.quiz.model.StudentModel;

public class StudentService {
	public void displayStudents() {
		try (StudentDao studentDao = new StudentDao()) { 
			List<StudentModel> studentList = studentDao.getAllStudentModels();
			for (StudentModel student : studentList) {
				System.out.println("Rollno: " + student.getRollno());
				System.out.println("Name: " + student.getName());
				System.out.println("Course: " + student.getCourse());
				System.out.println("----------------------");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void addStudent(Scanner sc) {
		StudentModel student = new StudentModel();
		System.out.println("Enter the Name: ");
		student.setName(sc.next());
		System.out.println("Enter the Email: ");
		student.setEmail(sc.next());
		System.out.println("Enter the Course: ");
		student.setCourse(sc.next());
		try (StudentDao studentDao = new StudentDao()) {
			studentDao.insertStudent(student);
			System.out.println("Student Added successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void editStudent(Scanner sc) {
		System.out.println("Enter the Rollno: ");
		int rollno = sc.nextInt();
		System.out.println("Enter the New Course: ");
		String course = sc.next();
		try (StudentDao studentDao = new StudentDao()) {
			studentDao.updateStudent(rollno, course);
			System.out.println("Student Updated Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeStudent(Scanner sc) {
		System.out.println("Enter the Rollno: ");
		int rollno = sc.nextInt();
		try(StudentDao studentDao = new StudentDao()) {
			studentDao.deleteStudent(rollno);
			System.out.println("Student Deleted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}
