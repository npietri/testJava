
public class Tableau {
	
	public static void main(String[] args) {
		
	
	int premiersNombres[][] = { {0,2,4,6,8},{1,3,5,7,9} };
	 
	for(int i = 0; i < 2; i++)
	{    
	  for(int j = 0; j < 5; j++)
	  {
	    System.out.print(premiersNombres[i][j]);       
	  }
	  System.out.println("");     
	}
	
	
	String tab[][]={{"toto", "titi", "tutu", "tete", "tata"}, {"1", "2", "3", "4"}};
	int i = 0, j = 0;
	 
	for(String sousTab[] : tab)
	{
	  i = 0;
	  for(String str : sousTab)
	  {     
	    System.out.println("La valeur de la nouvelle boucle est  : " + str);
	    System.out.println("La valeur du tableau à l'indice ["+j+"]["+i+"] est : " + tab[j][i]);
	    i++;
	  }
	  j++;
	}
	
	}
}
