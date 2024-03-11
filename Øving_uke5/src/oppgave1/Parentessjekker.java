package oppgave1;

public class Parentessjekker {
	public static void main(String[] args) {
		String javaprogram = """
				class HelloWorld {
				 public static void main(String[] args) {
				 System.out.println("Hello World!");
				 }
				}
				""";
		boolean result = sjekkParenteser(javaprogram);
		System.out.println(result);
	}
	
	private static boolean sjekkParenteser(String s) {
		char[] cArray = s.toCharArray();
		StabelADT<Character> charStabel = new TabellStabel<>();
		for (char c : cArray) {
			if (erStartParentes(c)) {
				charStabel.push(c);
				System.out.print(c);
			}
			if (erSluttParentes(c)) {
				System.out.print(c);
				char forrigeChar = charStabel.pop();
				if (!erParParentes(forrigeChar, c)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean erStartParentes(char c) {
		char[] startParenteser = {'(', '[','{'};
		for (char sP : startParenteser) {
			if (c == sP) {
				return true;
			}
		}
		return false;
	}

	private static boolean erSluttParentes(char c) {
		char[] sluttParenteser = {')', ']','}'};
		for (char sP : sluttParenteser) {
			if (c == sP) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean erParParentes(char start, char slutt) {
		if (start == '(' && slutt == ')') {
			return true;
		}
		if (start == '[' && slutt == ']') {
			return true;
		}
		if (start == '{' && slutt == '}') {
			return true;
		}
		return false;
	}
}
