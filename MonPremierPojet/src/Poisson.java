
public class Poisson extends AnimalFamilier{
	
	 int profondeurCourante = 0;

	  public int plonger(int combienDePlus){
	    profondeurCourante = profondeurCourante + 
	combienDePlus;
	    System.out.println("Plong�e de " + 
	            combienDePlus + " m�tres");
	    System.out.println("Je suis � " +
	profondeurCourante + 
	" m�tres sous le niveau de la mer");
	    return profondeurCourante; 
	  }

	  public String dire(String unMot) {
		  return "Ne sais-tu pas que les poissons ne parlent pas ?";
		} 
}
