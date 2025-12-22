package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.app.entity.Question;
import com.app.util.DbUtil;

public class QuestionDao implements AutoCloseable{
	public Connection con = null;
	
	public QuestionDao() throws SQLException {
		con = DbUtil.getConnection();
	}
	
	public List<Question> getAllQuestions() throws SQLException {
		List<Question> queList = new ArrayList<>();
		String sql = "SELECT question_id, quiz_id, question_text, option_a, option_b, option_c, option_d FROM questions";
		try (PreparedStatement selectStatement = con.prepareStatement(sql)) {
			ResultSet rs = selectStatement.executeQuery();
			while (rs.next()) {
				Question que = new Question();
				que.setId(rs.getInt(1));
				que.setQuiz_id(rs.getInt(2));
				que.setText(rs.getString(3));
				que.setA(rs.getString(4));
				que.setB(rs.getString(5));
				que.setC(rs.getString(6));
				que.setD(rs.getString(7));
				queList.add(que);
			}
		}
		return queList;
	}
	
	public List<Question> getQuestion(int qid) throws SQLException{
		List<Question> queList = new ArrayList<>();
		String sql = "SELECT question_text, option_a, option_b, option_c, option_d, correct_option FROM questions WHERE quiz_id = ?";
		try(PreparedStatement pt = con.prepareStatement(sql)){
			pt.setInt(1, qid);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				Question q = new Question();
				q.setText(rs.getString(1));
				q.setA(rs.getString(2));
				q.setB(rs.getString(3));
				q.setC(rs.getString(4));
				q.setD(rs.getString(5));
				String cop = rs.getString(6);
				q.setCorrect(cop.charAt(0));
				queList.add(q);
			} 
			rs.close();
			pt.close();
		}
		return queList;
	}
	
	public void insert (Question q) throws Exception {
		String sql = "INSERT INTO questions " + "(quiz_id, question_text, option_a, option_b, option_c, option_d, correct_option)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, q.quiz_id);
			ps.setString(2,q.text);
			ps.setString(3,q.a);
			ps.setString(4,q.b);
			ps.setString(5,q.c);
			ps.setString(6,q.d);
			ps.setString(7, String.valueOf(q.getCorrect()));
			ps.executeUpdate();
		}
	}
	
	public void close() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}

	
}
