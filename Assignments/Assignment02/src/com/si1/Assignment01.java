package com.si1;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Throwable;

public class Assignment01 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int rollno, marks, no, op = 0;
		String name;
		List<Student> stu = new ArrayList<Student>();
		try {
			System.out.print("Enter How Many Student you want to Store: ");
			no = sc.nextInt();
			while(op!=7) {
				System.out.print("--Menu--\n1. Add Student\n2. Display Students\n3. Search Student\n4. Sort Students on Rollno\n5. Sort Students on Name\n"
						+ "6. Sort the Student on Marks\n7. Exit\n");
				System.out.print("Enter Option: ");
				op = sc.nextInt();
				switch(op) {
					case 1: 
						for(int i=0; i<no; i++) {
						System.out.print("Enter Student Rollno: ");
						rollno = sc.nextInt();
						System.out.print("Enter Student Marks: ");
						marks = sc.nextInt();
						System.out.print("Enter Student Name: ");
						name = sc.next();
						stu.add(new Student(rollno, marks, name));
					}
					break;
					case 2: 
						for(Student s : stu) {
						System.out.print(s.toString());
						System.out.println();
					}
					break;
					case 3: 
						System.out.print("Enter Rollno of Student to Search: ");
						int find = sc.nextInt();
						for(Student t : stu) {
							t.searchRollno(find);
							System.out.println("Student Found!");
							System.out.println(t.toString());
						}
					break;	
					case 4:
						stu.sort(Comparator.comparing(Student::getRollno));
						System.out.println("Sorted By Rollno: ");
						System.out.print(stu);
					break;
					case 5:
						stu.sort(Comparator.comparing(Student::getName));
						System.out.println("Sorted By Rollno: ");
						System.out.print(stu);
					break;
					case 6:
						stu.sort(Comparator.comparing(Student::getMarks));
						System.out.println("Sorted By Rollno: ");
						System.out.print(stu);
					break;
						
					}
			}
			sc.close();
		} 
		catch(Throwable e) {
			System.out.println("Invalid Input");
		}
	}


}
