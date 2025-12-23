stpackage com.dkte.quiz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dkte.quiz.model.StudentModel;
import com.dkte.quiz.util.DButil;

public class StudentDao implements AutoCloseable{
	
	private Connection connection = null;
	
	public StudentDao() throws SQLException {
		connection = DButil.getConnection();
	}
	
	public List<StudentModel> getAllStudentModels() throws SQLException {
		List<StudentModel> studentList = new ArrayList<>();
		String sql = "SELECT rollno, name, email, course FROM Student";
		try (PreparedStatement selectStatement = connection.prepareStatement(sql)) {
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				StudentModel student = new StudentModel();
				student.setRollno(rs.getInt(1));
				student.setName(rs.getString(2));
				student.setEmail(rs.getString(3));
				student.setCourse(rs.getString(4));
				studentList.add(student);
			}
		}
		return studentList;
	}
	
	public void insertStudent(StudentModel student) throws SQLException {
		String sql = "INSERT INTO Student (name, email, course) VALUES (?, ?, ?)";
		try (PreparedStatement insertStatement = connection.prepareStatement(sql)) {
			insertStatement.setString(1, student.getName());
			insertStatement.setString(2, student.getEmail());
			insertStatement.setString(3, student.getCourse());
			insertStatement.executeUpdate();
		}
	}
	
	public void updateStudent(int rollno, String course) throws SQLException {
		String sql = "UPDATE Student SET course = ? WHERE rollno = ?";
		try (PreparedStatement updateStatement = connection.prepareStatement(sql)) {
			updateStatement.setString(1, course);
			updateStatement.setInt(2, rollno);
			updateStatement.executeUpdate();
		}
	}
	
	public void deleteStudent(int rollno) throws SQLException {
		String sql = "DELETE FROM Student WHERE rollno = ?";
		try (PreparedStatement deleteStatement = connection.prepareStatement(sql)) {
			deleteStatement.setInt(1, rollno);
			deleteStatement.executeUpdate();
		}
	}
	
	public void close() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
	}
}
