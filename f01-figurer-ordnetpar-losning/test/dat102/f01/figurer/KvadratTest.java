package dat102.f01.figurer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class KvadratTest {
	
	@Test
	void fungererArealOgOmkrets() {
		Figur2D k = new Kvadrat(3);
		assertEquals(9.0, k.areal());
		assertEquals(12.0, k.omkrets());
	}
}
