package com.codelifee.schoolmanagement.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.codelifee.schoolmanagement.util.DatabaseUtil;

@Service
public class SubjectDAO {

	public int addSubject(SubjectDTO subjectDTO) {
		String sql = "INSERT INTO subject VALUES(?, ?)";
		Connection con=null;
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			con = DatabaseUtil.getConnection();
			pt = con.prepareStatement(sql);
			pt.setString(1, subjectDTO.getSubject());
			pt.setString(2, subjectDTO.getName());
			return pt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(con != null) con.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pt != null) pt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -1; //database error
	}
	
	public int delete(String subject) {
		String sql = "DELETE FROM subject where subject=?";
		Connection con =null;
		PreparedStatement pt = null;
		ResultSet rs = null;
		
		try {
			con = DatabaseUtil.getConnection();
			pt = con.prepareStatement(sql);
			pt.setString(1, subject); 
			return pt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {if(con != null) con.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pt != null) pt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		return -1; // database error
	}
	
	public ArrayList<SubjectDTO> getList (String name) {
		ArrayList<SubjectDTO> subjectList=null;
		String sql="SELECT * FROM subject WHERE name=?";
		Connection con=null;
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			con = DatabaseUtil.getConnection();
			pt = con.prepareStatement(sql);
			pt.setString(1, name);
			rs = pt.executeQuery();
			subjectList = new ArrayList<SubjectDTO>();
			
			while(rs.next()) {
				SubjectDTO subject = new SubjectDTO(rs.getString(1), rs.getString(2));
				System.out.println(rs);
				subjectList.add(subject);
				System.out.println(subjectList);
			} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {if(con != null) con.close();} catch (Exception e) {e.printStackTrace();}
			try {if(pt != null) pt.close();} catch (Exception e) {e.printStackTrace();}
			try {if(rs != null) rs.close();} catch (Exception e) {e.printStackTrace();}
		}
		
		
		System.out.println(subjectList);
		return subjectList;
	}
}
