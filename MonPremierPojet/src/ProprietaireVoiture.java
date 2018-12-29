
public class ProprietaireVoiture {

	public static void main(String[] args) {
		
		int distanceParcourue;
		
		Voiture VoitureUne = new Voiture();
		
		
		VoitureUne.demarrer();
		VoitureUne.arreter();
		
		distanceParcourue = VoitureUne.rouler(10);
		System.out.println("la voiture a roulé à " + distanceParcourue + " km" );
		
		VoitureJamesBond VoitureDeux = new VoitureJamesBond();
		distanceParcourue = VoitureDeux.rouler(10);
		System.out.println("la voiture Deux a roulé à " + distanceParcourue + " km" );
		
	}

}
