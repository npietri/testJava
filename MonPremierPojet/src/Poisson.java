
public class Poisson extends AnimalFamilier {

	int profondeurCourante = 0;

	public int plonger(int combienDePlus) {
		profondeurCourante = profondeurCourante + combienDePlus;
		if (profondeurCourante>100) {
			System.out.println("poisson trop et ne peut plonger si bas");
			profondeurCourante = profondeurCourante - combienDePlus;
		}
		else {
		System.out.println("Plongée de " + combienDePlus + " mètres");
		System.out.println("Je suis à " + profondeurCourante + " mètres sous le niveau de la mer");
		}
		return profondeurCourante;
	}

	public String dire(String unMot) {
		return "Ne sais-tu pas que les poissons ne parlent pas ?";
	}
}
