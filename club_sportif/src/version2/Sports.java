package version2;

public class Sports {
	
	public static final int TENNIS = 0 ;
	public static final int NATATION = 1 ;
	public static final int PETANQUE = 2 ;
	public static final int BOBSLEIGH = 3 ;
	public static final int RANDONNEE = 4 ;
	public static final int VELO = 5 ;
	public static final int ESCALADE = 6 ;
	public static final int ATHLETISME = 7 ;
	
	static String nom(int sport) {
		String nomSport = "" ;
		switch (sport) {
		
		case 0 :
			nomSport = "TENNIS" ;
			break ;
			
		case 1 :
			nomSport = "NATATION" ;
			break ;			

		case 2 :
			nomSport = "PETANQUE" ;
			break ;
			
		case 3 :
			nomSport = "BOBSLEIGH" ;
			break ;			

		case 4 :
			nomSport = "RANDONNEE" ;
			break ;

		case 5 :
			nomSport = "VELO" ;
			break ;		

		case 6 :
			nomSport = "ESCALADE" ;
			break ;

		case 7 :
			nomSport = "ATHLETISME" ;
			break ;	
			
		default :
			nomSport = "" ;
		}
		
	return nomSport ;

	}

}
