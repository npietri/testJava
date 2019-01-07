
public class ConvertisseurTemperatures {


	public static void main(String[] args) {
		ConvertisseurTemperatures convertisseur = new ConvertisseurTemperatures();
		System.out.println("27 degres celcius font "+convertisseur.convertirTemperature(27, 'F'));
		System.out.println("80 degres farenheit font "+convertisseur.convertirTemperature(80, 'C'));
	}
	
	public String convertirTemperature (int temperature, char convertirEn){
		String valeurDeRetour;
		switch(convertirEn){
		case 'C':
			float temperatureEnCelcius = (5f/9f) * (temperature - 32);
			valeurDeRetour = temperatureEnCelcius+" celcius";
			break;
		case 'F':
			float temperatureEnFarenheit = (9f/5f) * temperature + 32;
			valeurDeRetour = temperatureEnFarenheit+" farenheit";
			break;
		default :
			valeurDeRetour = "Erreur de conversion";
		}
		return valeurDeRetour;
	}


}