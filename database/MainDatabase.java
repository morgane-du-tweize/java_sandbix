package testDB;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Reuh {
	public static void main(String[] args) throws Exception {
		
		Properties props = new Properties();
		try (FileReader fis = new FileReader("conf.properties")){
			props.load(fis);
		}
		
		String className = props.getProperty("jdbc.driver.class") ;
		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String password = props.getProperty("jdbc.password");

		Class.forName(className);
		String request = "SELECT * FROM users";
		try (
				Connection connection = DriverManager.getConnection (url, login, password );
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(request);
			){
				while (resultSet.next()) {
					String userLog = resultSet.getString("login");
					System.out.println(userLog);
				}
		};


	}
}
