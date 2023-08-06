package manipResultSet;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class ScrollingResultSet {

	public static void main(String[] args) throws Exception {
		
		Properties props = new Properties();
		try (FileInputStream fis = new FileInputStream("conf.properties")){
			props.load(fis);
		}

		String className = props.getProperty("jdbc.driver.class") ;
		String url = props.getProperty("jdbc.url");
		String login = props.getProperty("jdbc.login");
		String password = props.getProperty("jdbc.password");
		Class.forName(className);
		
		try (Connection connection = DriverManager.getConnection(url, login, password)){
			String strSql = "SELECT * FROM users;";
			try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)){
				try (ResultSet resSet = statement.executeQuery(strSql)){

					resSet.last();
					System.out.println(resSet.getString("login"));
					while (resSet.previous()) {
						System.out.println(
								" utilisateur : "  + resSet.getString("login") + " - nombre de connections : "
								+ resSet.getInt(4)
						);}

				}
			}
		}

	}

}
