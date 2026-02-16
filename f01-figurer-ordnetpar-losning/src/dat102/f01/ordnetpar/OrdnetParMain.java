package dat102.f01.ordnetpar;

public class OrdnetParMain {
	
	public static void main(String[] args) {
		
		OrdnetPar<String> arneOgNils = new OrdnetParImpl<>("Arne", "Nils");
		System.out.println(arneOgNils);
		
		arneOgNils.byttOm();
		System.out.println(arneOgNils);
		
		String forste = arneOgNils.forste();
		System.out.println(forste.length());
	}

}
