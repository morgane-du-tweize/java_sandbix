package WriteInFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AutreMain {

	public static void main(String[] args) throws IOException {
		
		try {
			File myObj  = new File("filename.txt");
			if (myObj.exists()) {
				System.out.println("File name : " + myObj.getName());
				System.out.println("Absolute path : " + myObj.getAbsolutePath());
				System.out.println("Canonical path : " + myObj.getCanonicalPath());
				System.out.println("Writeable : " + myObj.canWrite());
				System.out.println("Readable : " + myObj.canRead());
				System.out.println("File size : " + myObj.length());
			}
			else {			
				System.out.println("File does not exist");
				// tenter de créer ledit fichier
				
				PrintWriter sortie ;
				sortie = new PrintWriter(new BufferedWriter( new FileWriter("filename.txt") ));				

				sortie.println("Bonjour");
				sortie.print("petit essai");
				sortie.println("\nfin de l'essai");
				
				sortie.close();

			}
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
