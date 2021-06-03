package com.manage;

import java.sql.*;

public class StudentDao {
	
	public static boolean insertStudenttoDB(Student st) {
		
		//JDBC code to insert data into Database
		boolean flag = false;
		try {
			
			Connection conn = ConnectionProvider.createConnection();
			String query = "insert into students(sname, sphone, scity) values(?, ?, ?)";
			
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			//Set the value Parameter
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//Execute Query
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		try {
			
			Connection conn = ConnectionProvider.createConnection();
			String query = "delete from students WHERE sid=?";
			
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			//Set the value Parameter
			pstmt.setInt(1, userId);
			
			//Execute Query
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;		
	}

	public static void showAllStudent() {
		
		try {
			Connection conn = ConnectionProvider.createConnection();
			String query = "select * from students";
			
			//Statement
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String city = rs.getString(4);
				
				System.out.println("Id:- " + id + " " + "Name:- " + " " + name + " " + "Phone No.:- " + " " + phone + " " + "City:- " + " " + city);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static boolean updateStudent(Student ust) {
		
		boolean flag = false;
		try {
			
			Connection conn = ConnectionProvider.createConnection();
			String query = "update students SET sname=?, sphone=?, scity=? WHERE sid=?";
			
			//PreparedStatement
			PreparedStatement pstmt = conn.prepareStatement(query);
			
			//Set the value Parameter
			pstmt.setString(1, ust.getStudentName());
			pstmt.setString(2, ust.getStudentPhone());
			pstmt.setString(3, ust.getStudentCity());
			pstmt.setInt(4, ust.getStudentId());
			
			//Execute Query
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;	
		
	}
	
}
