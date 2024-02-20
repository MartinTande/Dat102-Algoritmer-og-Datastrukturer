package oppgave1;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortArrayTest {
	
	Integer[] fasit;
	Integer[] tabellA;
	Integer[] tabellB;
	Integer[] tabellC;
	
	@BeforeEach
	void setUp() throws Exception {
		fasit = new Integer[]{1,2,3,4,5,6,7,8,9};
		
		tabellA = new Integer[]{9,3,1,6,8,4,5,2,7};
		tabellB = new Integer[]{9,3,7,6,8,4,5,2,1};
		tabellC = new Integer[]{8,3,7,6,9,4,5,2,1};
	}

	@Test
	void testInsertionSort1() {
		assertArrayEquals(fasit, SortArray.insertionSort(tabellA));
		assertArrayEquals(fasit, SortArray.insertionSort(tabellB));
		assertArrayEquals(fasit, SortArray.insertionSort(tabellC));
	}
	
	@Test
	void testInsertionSort2() {
		assertArrayEquals(fasit, SortArray.insertionSort2(tabellA));
		assertArrayEquals(fasit, SortArray.insertionSort2(tabellB));
		assertArrayEquals(fasit, SortArray.insertionSort2(tabellC));
	}

	@Test
	void testInsertionSort3() {
		assertArrayEquals(fasit, SortArray.insertionSort3(tabellA));
		assertArrayEquals(fasit, SortArray.insertionSort3(tabellB));
		assertArrayEquals(fasit, SortArray.insertionSort3(tabellC));
	}
	
	@Test
	void testSelectionSort() {
		SortAlgorithm.selectionSort(tabellA);
		SortAlgorithm.selectionSort(tabellB);
		SortAlgorithm.selectionSort(tabellC);
		assertArrayEquals(fasit, tabellA);
		assertArrayEquals(fasit, tabellB);
		assertArrayEquals(fasit, tabellC);
	}
	
	@Test
	void testMergeSort() {
		SortAlgorithm.mergeSort(tabellA);
		SortAlgorithm.mergeSort(tabellB);
		SortAlgorithm.mergeSort(tabellC);
		assertArrayEquals(fasit, tabellA);
		assertArrayEquals(fasit, tabellB);
		assertArrayEquals(fasit, tabellC);
	}
	
	@Test
	void testQuickSort() {
		SortAlgorithm.quickSort(tabellA);
		SortAlgorithm.quickSort(tabellB);
		SortAlgorithm.quickSort(tabellC);
		assertArrayEquals(fasit, tabellA);
		assertArrayEquals(fasit, tabellB);
		assertArrayEquals(fasit, tabellC);
	}
}
