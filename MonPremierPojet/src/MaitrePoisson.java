
public class MaitrePoisson {
	
	 
  public static void main(String[] args) {
		
    Poisson monPoisson = new Poisson();
		
    monPoisson.plonger(2);
    monPoisson.plonger(3);
		
    monPoisson.dormir();
    
  
    String r�actionPoisson;
    r�actionPoisson = monPoisson.dire("Salut");
    System.out.println(r�actionPoisson);
  }
}