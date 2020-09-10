package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import entity.User;

public class Table1Model {
public List<User> email(DataSource ds){
	List<User> list = new ArrayList<>();
	Connection connect = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		connect = ds.getConnection();
		String query = "SELECT * FROM aman.table1";
		stmt = connect.createStatement();
		rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			list.add(new User(rs.getInt("userId"),rs.getString("email")));
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return list;
}

public void addEmail(DataSource ds, User newUser) {
	 Connection connect = null;
	 PreparedStatement ps= null;
	 
	 try {
		 connect = ds.getConnection();
		 String Email = newUser.getEmail();
		 String query = "insert into table1(email) values(?)";
		ps= connect.prepareStatement(query);
		ps.setString(1, Email);
		ps.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 
}

public void updateEmail(DataSource ds, User updateUser) {
	Connection connect = null;
	PreparedStatement ps = null;
	String email = updateUser.getEmail();
	int i = updateUser.getUserId();
	try {
		connect = ds.getConnection();
		String query = "update table1 set email= ? where userId= ?";
		ps= connect.prepareStatement(query);
		ps.setString(1,email);
		ps.setInt(2,i);
		ps.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

public void deleteEmail(DataSource ds, User deleteUser) {
	Connection connect = null;
	PreparedStatement ps = null;
	int id = deleteUser.getUserId();
	try {
		connect = ds.getConnection();
		String query = "DELETE FROM table1 WHERE userId= ?";
		ps= connect.prepareStatement(query);
		ps.setInt(1, id);
		ps.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}



}
