package com.database.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCBasic {
	public static void main(String[] args) {
		try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDatabase", "postgres", "Test@1234");) {
			
			String query = "select * from \"Students\" "
					+ "ORDER BY id ASC ";
			
			Statement p =  con.createStatement();
			ResultSet result = p.executeQuery(query);
//			ResultSet result = p.getResultSet();
			
			while(result != null && result.next()) {
				
				System.out.println("ID: " + result.getLong("id"));
				System.out.println("Name: " + result.getString("name"));
			}
			
			System.out.println();
			
			System.out.println("End");
			
			
			
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
