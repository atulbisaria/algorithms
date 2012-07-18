package com.ericsson.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String dbtime;
		String dbUrl = "jdbc:mysql://localhost/atul_new";
		String dbClass = "com.mysql.jdbc.Driver";
		String query = "Select * FROM students";

		try {

			Class.forName(dbClass);
			Connection con = DriverManager.getConnection(dbUrl, "root", "brother");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				dbtime = rs.getString(2);
				System.out.println(dbtime);
			} // end while

			con.close();
		} // end try

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
