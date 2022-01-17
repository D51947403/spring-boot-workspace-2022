package com.singraul.boot.restapi.product.repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
// This is only to test JDBC connection
//This is not a part of this project
public class JdbcConnectionUtil {

	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306";
		String dbSchema = "mydb";
		String userName = "boot";
		String password = "boot";
		try {

			// This is deprecated.
			// Class.forName("com.mysql.jdbc.Driver");

			// MySQL version 8.0.17
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url + "/" + dbSchema, userName, password);
			// System.out.println("Connection "+con);

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return con;

	}

	public static void main(String args[]) {

		Connection con = getConnection();

		System.out.println("Connection established \n " + con);

		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from tt_product");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " "
						+ rs.getString(4));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}