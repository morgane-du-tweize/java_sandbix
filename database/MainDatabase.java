package testDB;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainDatabase {
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
		try (Connection connection = DriverManager.getConnection (url, login, password )){
			
			while (true) {
				System.out.println("Veuillez saisir votre nom d'utilisateur");
				String typedLogin = scan.nextLine().trim();
				System.out.println("Veuillez saisir votre mot de passe");
				String typedPassword = scan.nextLine().trim();

				String strSql = "SELECT * FROM users WHERE login =? AND password =? ;" ;
				
				try (PreparedStatement statement = connection.prepareStatement(strSql)) {
					statement.setString(1, typedLogin);
					statement.setString(2, typedPassword);
					try (ResultSet resultSet = statement.executeQuery()){
						if (resultSet.next()) {
							String userLogin = resultSet.getString("login");
							System.out.println("Bienvenue " + userLogin + " vous êtes maintenant connecté");
							break ;
						}
					}
				}

				System.out.println("Erreur - veuillez essayer de vous connecter à nouveau");
			}
		}

	}
}
