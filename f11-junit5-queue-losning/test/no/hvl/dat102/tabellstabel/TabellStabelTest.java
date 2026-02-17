package no.hvl.dat102.tabellstabel;

import java.util.EmptyStackException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabellStabelTest {
	
	private StabelADT<String> stabel0; //Tenker at denne er en tom stabel
	private StabelADT<String> stabel1; //Tenker at denne er en stabel med ett element
	private StabelADT<String> stabel2; //Tenker at denne er en stabel med to elementer

	@BeforeEach
	void nullstill() {
		stabel0 = new TabellStabel<>();
		stabel1 = new TabellStabel<>();
		stabel2 = new TabellStabel<>();
		stabel1.push("Pomerans");
		stabel2.push("Dragefrukt");
		stabel2.push("Physalis");
	}
	
	/*
	 * Ting å teste (vi har konstruktør, isEmpty, push, peek, pop, clear):
	 * 
	 * - En ny stabel skal være tom
	 * - En stabel med ett eller to element(er) skal ikke være tom
	 * - push skal legge elementet på toppen av stabelen
	 * - peek på en tom stabel skal gi EmptyStackException
	 * - peek på en ikke-tom stabel skal returnere topp-elementet (siste push)
	 * - peek på en ikke-tom stabel skal ikke endre på stabelens innhold
	 * - pop på en tom stabel skal gi EmptyStackException
	 * - pop på en ikke-tom stabel skal fjerne og returnere topp-elementet
	 * - clear skal tømme stabelen
	 */
	
	@Test
	void enNyStabelSkalVaereTom() {
		assertTrue(stabel0.isEmpty());
	}
	
	@Test
	void enStabelMedEttEllerFlereElementerSkalIkkeVaereTom() {
		assertFalse(stabel1.isEmpty());
		assertFalse(stabel2.isEmpty());
	}
	
	@Test
	void pushSkalLeggeElementetPaaToppenAvStabelen() {
		stabel1.push("Banan");
		assertEquals("Banan", stabel1.peek());
	}
	
	@Test
	void peekPaaTomStabelSkalGiEmptyStackException() {
		assertThrows(EmptyStackException.class, () -> stabel0.peek());
	}
	
	@Test
	void peekPaaIkkeTomStabelSkalReturnereToppelementet() {
		assertEquals("Pomerans", stabel1.peek());
		assertEquals("Physalis", stabel2.peek());
	}
	
	@Test
	void peekPaaIkkeTomStabelSkalIkkeEndreStabelensInnhold() {
		assertEquals(stabel1.peek(), stabel1.peek());
		stabel2.peek();
		assertEquals(stabel2.peek(), "Physalis");
	}
	
	@Test
	void popPaaTomStabelSkalGiEmptyStackException() {
		assertThrows(EmptyStackException.class, () -> stabel0.pop());
	}
	
	@Test
	void popPaaIkkeTomStabelSkalFjerneOgReturnereToppelementet() {
		String peekElement = stabel2.peek();
		String popElement = stabel2.pop();
		String peekElement2 = stabel2.peek();

		assertTrue(peekElement.equals(popElement));
		assertNotEquals(peekElement, peekElement2);
		assertEquals(popElement, "Physalis");
	}
	
	@Test
	void clearSkalTommeStabelen() {
		stabel2.clear();
		assertTrue(stabel2.isEmpty());
	}
}
