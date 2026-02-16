package dat102.f04.tatiden;

import java.util.function.UnaryOperator;

public class Sum1TilNMain {

	public static void main(String[] args) {
		
		final long N = 100_000L;
		
		taTidOgSkrivUt("A", Sum1TilNMain::sum1tilnAlgoA, N);
		taTidOgSkrivUt("B", Sum1TilNMain::sum1tilnAlgoB, N);
		taTidOgSkrivUt("C", Sum1TilNMain::sum1tilnAlgoC, N);
	}
	
	// -------------------------------------------------------------
	
	private static long sum1tilnAlgoA(long n) {
		
		long sum = 0;
		for (long i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

	private static long sum1tilnAlgoB(long n) {

		long sum = 0;
		for (long i = 1; i <= n; i++) {
			for (long j = 1; j <= i; j++) {
				sum++;
			}
		}
		return sum;
	}

	private static long sum1tilnAlgoC(long n) {
		return n * (n+1) / 2;
	}

	// -------------------------------------------------------------
	
	private static void taTidOgSkrivUt(String abc, UnaryOperator<Long> fu, long n) {
		
		System.out.print("Algoritme " + abc + " ");
		
		long startMillis = System.currentTimeMillis();
		long sum = fu.apply(n);
		long millis = System.currentTimeMillis() - startMillis;
		
		System.out.println("("+ millis + " ms): Sum = " + sum);
	}
}
