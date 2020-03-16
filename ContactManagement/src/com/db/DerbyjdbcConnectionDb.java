package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.domain.PhoneDomain;

public class DerbyjdbcConnectionDb {

	private final String path = "jdbc:derby:c/contactsDb;create=true";
	private final String username = "";
	private final String password = "";
	
	static {
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbedDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() {
		
		Connection connect = null;
		
		try {
			connect = DriverManager.getConnection(path,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connect;
	}
	
	
	public DerbyjdbcConnectionDb() {
		initTable();
	}
	
	public void initTable() {
		
		Connection connect = getConnection();
		
		try {
			Statement query = connect.createStatement();
			query.executeUpdate("CREATE TABLE contacts (id INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY" +
					"(START WITH 1,INCREMENT BY 1), " +
					"FirstName VARCHAR(50), " +
					"LastName VARCHAR(50), " +
					"Phone VARCHAR(50))");
			
		} catch (SQLException e) {
			System.out.println("Table has been created.");
		}
		
	}
	
	public void newRecord(PhoneDomain newRecord) {
		
		Connection connect = getConnection();
		try {
			Statement query = connect.createStatement();
			query.executeUpdate("INSERT INTO contacts (FirstName, LastName, Phone) VALUES "
					+ "('"+newRecord.getFname()+"','"
					+newRecord.getLname()+"','"
					+newRecord.getPhone()+"') ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
