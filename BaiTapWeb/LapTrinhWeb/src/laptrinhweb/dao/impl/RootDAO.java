package laptrinhweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public abstract class RootDAO {
	public SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public Connection getJDBCConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/laptrinhweb?useUnicode=true&characterEncoding=UTF-8", "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
