package dat102.f01.ordnetpar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OrdnetParJUnitTest {

	@Test
	void test() {
		
		OrdnetPar<Integer> treOgTo = new OrdnetParImpl<>(3, 2);
		
		assertEquals(3, treOgTo.forste());
		assertEquals(2, treOgTo.andre());
		
		treOgTo.byttOm();
		
		assertEquals(2, treOgTo.forste());
		assertEquals(3, treOgTo.andre());

	}

}
