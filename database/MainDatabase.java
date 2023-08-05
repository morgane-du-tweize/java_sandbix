package testDB;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MainDatabase {
	public static void main(String[] args) throws Exception {
		
		// Etablir la connection
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
				// Saisir données utilisateur
				System.out.println("Veuillez saisir votre nom d'utilisateur");
				String typedLogin = scan.nextLine().trim();
				System.out.println("Veuillez saisir votre mot de passe");
				String typedPassword = scan.nextLine().trim();

				String strSql = "SELECT * FROM users WHERE login = '" + typedLogin + "' AND password = '" + typedPassword + "' ;" ;
				
				try (
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(strSql);	
					) {
					if (resultSet.next()) {
						String userLogin = resultSet.getString("login");
						System.out.println("Bienvenue " + userLogin + " vous êtes maintenant connecté");
						break ;
					}
				}
				System.out.println("Erreur - veuillez essayer de vous connecter à nouveau");
			}
		}

	}
}
