package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static Connection con;
	public Database() {
		// TODO Auto-generated constructor stub
		try {
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=PTUD","sa","a123456789");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static Connection getCon(){
		if(con == null)
			new Database();
		return con;
	}
}
