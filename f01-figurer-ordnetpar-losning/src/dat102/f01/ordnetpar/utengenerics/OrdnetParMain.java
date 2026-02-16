package dat102.f01.ordnetpar.utengenerics;

public class OrdnetParMain {
	
	public static void main(String[] args) {
		
		OrdnetPar perOg17 = new OrdnetParImpl(17, "Per");
		System.out.println(perOg17);
		
		perOg17.byttOm();
		System.out.println(perOg17);
		
		String forste = (String) perOg17.forste();
		System.out.println(forste.length());
	}

}
