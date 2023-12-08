package bank_modules;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
	Connection c;
	Statement s;
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/bankmanagementsystem";
	static final String USER = "root";
	static final String PASS = "";
	
	public DbConnection() {
		
		try {
		    c = DriverManager.getConnection(DB_URL,USER,PASS);
			s = c.createStatement();	
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
