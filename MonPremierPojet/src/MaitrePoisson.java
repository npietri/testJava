
public class MaitrePoisson {
	
	 
  public static void main(String[] args) {
		
    Poisson monPoisson = new Poisson();
		
    monPoisson.plonger(2);
    monPoisson.plonger(3);
		
    monPoisson.dormir();
    
  
    String réactionPoisson;
    réactionPoisson = monPoisson.dire("Salut");
    System.out.println(réactionPoisson);
  }
}