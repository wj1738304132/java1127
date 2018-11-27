package com.chinasoft.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasoft.model.User;

public class UserDao {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int addUser(User user ){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			pst=conn.prepareStatement("insert into student(username,userpwd,userage,userFileName) value(?,?,?,?)");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getUserpwd());
			pst.setInt(3, user.getUserage());
			pst.setString(4, user.getUserFileName());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	public List<User> queryUser(){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			pst=conn.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			List<User> list=new ArrayList<User>();
			while(rs.next()){
				User user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setUserpwd(rs.getString(3));
				user.setUserage(rs.getInt(4));
				user.setUserFileName(rs.getString(5));
				list.add(user);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public User dologin(String username,String userpwd){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			pst=conn.prepareStatement("select * from student where username=? and userpwd=?");
			pst.setString(1, username);
			pst.setString(2, userpwd);
			ResultSet rs=pst.executeQuery();
			List<User> list=new ArrayList<User>();
			User user=null;
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setUserpwd(rs.getString(3));
				user.setUserage(rs.getInt(4));
				user.setUserFileName(rs.getString(5));
			}
			
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public User queryUserById(Integer id){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			pst=conn.prepareStatement("select * from student where id=?");
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			User user=null;
			while(rs.next()){
				user=new User();
				user.setId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setUserpwd(rs.getString(3));
				user.setUserage(rs.getInt(4));
				user.setUserFileName(rs.getString(5));
			}
			
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public int update(User user){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			pst=conn.prepareStatement("update student set username=?,userpwd=?,userage=?,userFileName=? where id=?");
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getUserpwd());
			pst.setInt(3, user.getUserage());
			pst.setInt(5, user.getId());
			pst.setString(4, user.getUserFileName());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
	public int deleteUser(Integer id){
		Connection conn=null;
		PreparedStatement pst=null;
		try {
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
			pst=conn.prepareStatement("delete from student where id=?");
			pst.setInt(1, id);
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
}
