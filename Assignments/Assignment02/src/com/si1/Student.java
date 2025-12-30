package com.si1;

public class Student {
	
	int rollno, marks;
	String name;
	public Student(int rollno, int marks, String name) {
		this.rollno = rollno;
		this.marks = marks;
		this.name = name;
	}
	public Student() {
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", marks=" + marks + ", name=" + name + "]";
	}
	public int searchRollno(int find) {
		if(rollno == find)
			return 1;
		return 0;
	}
}
