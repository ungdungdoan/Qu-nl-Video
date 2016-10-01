package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {
	public static void close(Connection con) {
		if(con != null)
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	public static void close(Statement stmt) {
		if(stmt!=null)
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
	}
	
	public static void close(ResultSet rs,Statement stmt) {
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(stmt!=null)
			try {
				stmt.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
	}
}
