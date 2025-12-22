package com.app.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.util.DbUtil;

public class StudentDao implements AutoCloseable {
	private Connection con =null;
	
	public static int stuId;
	
	public StudentDao() throws SQLException{
		con = DbUtil.getConnection();
	}
	
	public boolean studentLogin(String email , String pass , String role) throws SQLException {
		String sql = "SELECT * FROM USERS WHERE email = ? AND password_hash = ? AND role = ?";
		try (PreparedStatement st= con.prepareStatement(sql)) {
			st.setString(1, email);
			st.setString(2, pass);
			st.setString(3, role);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				stuId = rs.getInt(1);
				return true;
			}
			rs.close();
			st.close();
		}
		return false;
	}
	public void studentRegister(String name ,String email , String pass , String role) throws SQLException {
		String sql = "INSERT INTO USERS(name , email , password_hash , role) VALUES(?,?,?,?)";
		try {
			PreparedStatement pt = con.prepareStatement(sql);
			pt.setString(1, name);
			pt.setString(2, email);
			pt.setString(3, pass);
			pt.setString(4, role);
			pt.executeUpdate();
			pt.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() throws Exception {
		if(con ==null) {
			con.close();
			con = null;
		}
	}
}
