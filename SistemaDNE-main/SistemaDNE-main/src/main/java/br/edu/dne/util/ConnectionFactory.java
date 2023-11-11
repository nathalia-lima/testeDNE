package br.edu.dne.util;

import java.sql.*;

public class ConnectionFactory {

	public static Connection getConnection() throws Exception {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			
			String login = "root";
			String senha = "Bryanedu1";
			String url = "jdbc:mysql://localhost:3306/dne";

			return DriverManager.getConnection(url,login,senha);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public static void closeConnection(Connection conn, Statement stmt,
			ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt)
			throws Exception {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs)
			throws Exception {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}