package oppgave2;

public class Rekursjon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		int sum = SumNaturligTall(n);
		System.out.println("Summen av " + n + " første naturlige tall: " + sum);
		
		int f = 45;
		long fibSum = fibonacci(f);
		long fibSumIt = fibonacciIterative(f);
		System.out.println("Summen av " + f + " første naturlige tall: " + fibSum);
		System.out.println("Summen av " + f + " første naturlige tall: " + fibSumIt);
	}
	
	private static int SumNaturligTall(int n) {
		if (n == 1) {
			return 1;
		}
		
		return SumNaturligTall(n - 1) + n;
	}
	
	public static boolean isPalindrome(String aString) {
		if (aString.length() <= 1) {
			return true;
		}

		char first = aString.charAt(0);
		char last = aString.charAt(aString.length()-1);
		String rest = aString.substring(1, aString.length()-1);
		
		if (first != last) {
			return false;
		} else {
			return isPalindrome(rest);
		}
	}
	
	public static long fibonacci(long n) {
		if (n <= 1) {
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public static long fibonacciIterative(long n) {
		if (n <= 1) {
			return n;
		}
		long i = 2;
		long two_before = 0;
		long one_before = 1;
		long current = 0;
		
		while (i <= n) {
			current = two_before + one_before;
			two_before = one_before;
			one_before = current;
			i++;
		}
		return current;
	}

}
