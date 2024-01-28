package TidsEffektivitet;

public class Main {

	public static void main(String[] args) {
		taTidPaaFunksjon(10_000_000L);
		taTidPaaFunksjon(100_000_000L);
		taTidPaaFunksjon(1_000_000_000L);
	}
	
	public static void tid(long n) {
		long k = 0;
		for (long i = 1; i < n; i++) {
			k = k + 5;
		}
	}
	
	public static void taTidPaaFunksjon(long n) {
		long startTime = System.currentTimeMillis();
		tid(n);
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;
		System.out.println("n = " + n + " tok " + elapsedTime + "ms");
	}

}
