package dat102.f04.lenketbag;

public class LenketBagMain {
	
	public static void main(String[] args) {
		
		BagADT<String> minBag = new LenketBag<>();
		minBag.add("Per");
		minBag.add("Pål");
		minBag.add("Espen");

		// Siden BagADT-interfacet ikke har metoden skrivUt(), kan vi ikke
		// bruke variabelen og skrive minBag.skrivUt().

		// Men hvis vi har en variabel av typen LenketBag, og antar at MinBag
		// er en LenketBag, kan vi skrive minLenketBag.skrivUt(). F.eks. slik:

		LenketBag<String> minLenketBag = (LenketBag<String>) minBag;
		minLenketBag.skrivUt();

	}

}
