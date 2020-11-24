package com.codelifee.schoolmanagement.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

import com.codelifee.schoolmanagement.util.DatabaseUtil;

@Service
public class StudentDAO {

	public int login(String name, String password) {
		String sql = "SELECT password FROM student WHERE name=?";
		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		
		try {
			con = DatabaseUtil.getConnection();
			pt = con.prepareStatement(sql);
			pt.setString(1, name);
			rs = pt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(password)) {
					return 1; // login success
				} else {
					return 0; // wrong password
				}
			}
			return -1; // ID does not exist
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(con != null) con.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pt != null) pt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -2; //database error
	}
	
	public int join(StudentDTO stu) {
		String sql = "INSERT INTO STUDENT VALUES (?, ?)";
		Connection con=null;
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			con = DatabaseUtil.getConnection();
			pt = con.prepareStatement(sql);
			pt.setString(1, stu.getName());
			pt.setString(2, stu.getPassword());
			pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(con != null) con.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pt != null) pt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -1; //register failure
	}
	
}
