package dao;

import db.ConnConst2;
import java.sql.*;

public class QueryOneParam {
	private static final String SQL =
			"SELECT * FROM employee WHERE empno = ?";
	
	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(ConnConst2.DB_URL, ConnConst2.USER, ConnConst2.PASSWORD);
				
			String empno = "1001";
			PreparedStatement stmt = conn.prepareStatement(SQL);
			stmt.setString(1, empno);
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				System.out.print("name = " + rs.getString("ename"));
				System.out.println(", salary = " + rs.getInt("salary"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) { 
					e.printStackTrace();
				}
		}
	}
}
