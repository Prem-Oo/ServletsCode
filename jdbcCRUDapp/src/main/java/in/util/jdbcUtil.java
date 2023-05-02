package in.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class jdbcUtil {
	Connection connection=null;
	PreparedStatement pstmt=null;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getJDBCconnection() throws SQLException {
		 HikariConfig config = new HikariConfig("src/main/java/in/util/db.properties");
		 HikariDataSource dataSource = new HikariDataSource(config);
			Connection connection = dataSource.getConnection();
			 return connection;
		
	}
	
	
	public static Connection getPhysicalconnection() throws SQLException, IOException{
		FileInputStream fis = new FileInputStream("src/main/java/in/util/db.properties");
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection =DriverManager.getConnection(url, user, password);
		return connection;
		
	}

}
