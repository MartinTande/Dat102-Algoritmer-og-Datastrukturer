package oppgave3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// a
		List<Integer> intList = new ArrayList<>();
		intList.add(6);
		intList.add(50);
		intList.add(444);
		intList.add(6);
		intList.add(32);
		
//		intList.add("Test");
		
		System.out.println(intList.get(3));
		System.out.println(intList.get(4));
		
		// b
		int numberOfElements = intList.size();
		System.out.println(numberOfElements);
		
		// c
		System.out.println(intList.contains(50));
		System.out.println(intList.contains(51));
		
		// d
		System.out.println(intList.indexOf(6));
		System.out.println(intList.lastIndexOf(6));
		
		// e
		System.out.println(intList);
		intList.clear();
		System.out.println(intList);
	}

}
