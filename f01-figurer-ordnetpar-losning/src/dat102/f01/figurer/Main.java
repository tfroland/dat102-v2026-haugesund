package dat102.f01.figurer;

public class Main {
	
	public static void skrivUt(Figur2D f) {
		System.out.println(f.areal());
		System.out.println(f.omkrets());
	}
	
	public static void main(String[] args) {
		
		Figur2D k = new Kvadrat(3);
		skrivUt(k);
		
		Figur2D s = new Sirkel(3);
		skrivUt(s);
	}
}
