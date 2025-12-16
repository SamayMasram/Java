package com.dkte;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Program01 {

	private static final String URL = "jdbc:mysql://localhost:3306/classwork";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "manager";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	public static void getAllStudents() {
		String sql1 = "SELECT * FROM Student";
			try {
			Connection connection = getConnection();
			PreparedStatement selectStatement = connection.prepareStatement(sql1);
			ResultSet rs = selectStatement.executeQuery();
			while(rs.next()) {
				int rollno = rs.getInt(1);
				String name = rs.getString(2);
				System.out.println(rollno+ "	" +name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void addStudents() {
		int rollno = 8;
		String name = "Arjun";
		String sql2 = "INSERT INTO Student (rollno, name) VALUES (?,?)";
		try {
			Connection connection = getConnection();
			PreparedStatement inertStatement = connection.prepareStatement(sql2);
			inertStatement.setInt(1, rollno);
			inertStatement.setString(2, name);
			inertStatement.execute();
			connection.close();
			inertStatement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void updateStudents() {
		String name = "Krishna";
		int rollno = 4;
		String sql3 = "UPDATE Student SET name=? WHERE rollno=?";
		try {
			Connection connection = getConnection();
			PreparedStatement updateStatement = connection.prepareStatement(sql3);
			updateStatement.setInt(2, rollno);
			updateStatement.setString(1, name);
			updateStatement.execute();
			connection.close();
			updateStatement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void deleteStudents() {
		String sql4 = "DELETE FROM Student WHERE rollno=2";
		try {
			Connection connection = getConnection();
			PreparedStatement deleteStatement = connection.prepareStatement(sql4);
			deleteStatement.clearBatch();
			deleteStatement.execute();
			connection.close();
			deleteStatement.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		addStudents();
		updateStudents();
		deleteStudents();
		getAllStudents();
		sc.close();
	}

}
