package essaiRead;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		/*
		 court programme pour tester la classe FileReader
		 les classes et méthodes employées ne sont pas nécesdairement
		 les mieux adaptées
		 */
		String fichierLecture = args[0];
		FileReader entree = new FileReader(fichierLecture);

		int c;StringBuilder chars = new StringBuilder();
		
		while((c = entree.read()) != -1) {
			chars.append(Character.toString(c));
		}
		String result = chars.toString();
		System.out.println(result);
		entree.close();

	}

}
