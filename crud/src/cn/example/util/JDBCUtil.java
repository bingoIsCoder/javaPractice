package cn.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	private static JDBCUtil instance = null;
	private static Properties prop = null;
	
	static {
		try {
			prop = new Properties();
			prop.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("jdbc.properties"));
			Class.forName(prop.getProperty("driverName"));
			instance = new JDBCUtil();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private JDBCUtil() {
		
	}
	
	public static JDBCUtil getInstance() { 
		return instance;
	}
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(prop.getProperty("url"), 
					prop.getProperty("userName"), prop.getProperty("password"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close(ResultSet rs, Statement st, Connection conn) {		
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {				
				try {
					if (st != null)
						st.close();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {				
					try {
						if (conn != null)
							conn.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			} 
	}
}
