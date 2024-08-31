package com.database.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementTestClass {

	public static void main(String[] args) throws SQLException {

		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TestDatabase", "postgres",
				"Test@1234");

		String query = "select * from \"Students\" " + "ORDER BY id ASC ";
		PreparedStatement st = con.prepareStatement(query);
		ResultSet result = st.executeQuery();

		while (result.next()) {

			System.out.println("ID: " + result.getLong("id"));
			System.out.println("Name: " + result.getString("name"));
		}
	}

}
