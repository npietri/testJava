
public class MaitreAnimal {

	public static void main(String[] args) {
		
		String reactionAnimal;
		
		AnimalFamilier monAnimal = new AnimalFamilier();
		
		monAnimal.manger();
		reactionAnimal = monAnimal.dire("cui!! cui!!");
		System.out.println(reactionAnimal);
		monAnimal.dormir();
		
		Poisson monPetitPoisson = new Poisson();
		monPetitPoisson.dormir();
		

	}

}
