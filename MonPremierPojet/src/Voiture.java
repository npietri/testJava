
public class Voiture{

	
	public void demarrer() {
		System.out.println("la voiture d�marre");
	}
	public void arreter() {
		System.out.println("la voiture s'arrete");
	}
	
	public int rouler(int duree) {
		int distance = duree * 60;
		return distance;
		
	}
	
	
	
}

