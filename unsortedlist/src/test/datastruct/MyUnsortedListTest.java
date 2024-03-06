package datastruct;

import static org.junit.Assert.*;

import org.junit.Test; 

public class MyUnsortedListTest {

	private MyUnsortedListTestMother testMother = new MyUnsortedListTestMother();
	
	@Test
	public void creationTest() {
		assertEquals(testMother.testMother, MyUnsortedList.of(1,2,3,4,5));
		assertNotEquals(testMother.testMother, MyUnsortedList.of(1,2,3,4));
	}
	
	@Test
	public void emptyTest() {
		assertFalse(testMother.testMother.isEmpty());
		assertTrue(MyUnsortedList.of().isEmpty());		
	}
	
	@Test
	public void sizeTest() {
		assertEquals(testMother.testMother.size(), 5);
		assertNotEquals(testMother.testMother.size(), 4);
		assertEquals(MyUnsortedList.of().size(), 0);
	}
	
	@Test
	public void prependTest() {
		MyUnsortedList lastTestMother = testMother.clone();
		testMother.testMother.prepend(0);
		assertNotEquals(testMother.testMother, lastTestMother);
		assertEquals(testMother.testMother, MyUnsortedList.of(0,1,2,3,4,5));
	}
	
	@Test
	public void appendTest() {
		MyUnsortedList lastTestMother = testMother.clone();
		testMother.testMother.append(6);
		assertNotEquals(testMother.testMother, lastTestMother);
		assertEquals(testMother.testMother, MyUnsortedList.of(1,2,3,4,5,6));
	}
	
	@Test
	public void insertTest() {
		MyUnsortedList prependExample = testMother.clone();
		prependExample.prepend(0);
		MyUnsortedList appendExample = testMother.clone();
		appendExample.append(6);
		
		MyUnsortedList prependTest = testMother.clone();
		prependTest.insert(0, 0);
		MyUnsortedList appendTest = testMother.clone();
		appendTest.insert(6, appendTest.size());
		
		assertEquals(prependExample, prependTest);
		assertEquals(appendExample, appendTest);
		assertNotEquals(testMother.testMother, prependTest);
		assertNotEquals(testMother.testMother, appendTest);
		
		MyUnsortedList insertMiddle = testMother.clone();
		insertMiddle.insert(3, 3);
		
		assertNotEquals(insertMiddle, testMother.testMother);
		assertEquals(insertMiddle, MyUnsortedList.of(1,2,3,3,4,5));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertOutOfBoundsExceptionTest() {
		MyUnsortedList.of(1).insert(3,4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void insertOutOfBoundsTwoExceptionTest() {
		MyUnsortedList.of(1).insert(-2,-4);
	}
	
	@Test
	public void popTest() {
		MyUnsortedList popTest = testMother.clone();
		
		assertEquals(popTest.pop(), 1);
		assertNotEquals(popTest.pop(), 3);
		
		assertNotEquals(popTest, testMother.testMother);
		assertEquals(popTest, MyUnsortedList.of(3,4,5));
	}
	
	@Test(expected = EmptyListException.class)
	public void popExceptionTest() {
		MyUnsortedList.of().pop();
	}
	
	@Test
	public void popLast() {
		MyUnsortedList popLastTest = testMother.clone();
		assertEquals(popLastTest.popLast(), 5);
		assertNotEquals(popLastTest.popLast(), 3);
		
		assertNotEquals(popLastTest, testMother.testMother);
		assertEquals(popLastTest, MyUnsortedList.of(1,2,3));
	}
	
	@Test(expected = EmptyListException.class)
	public void popLastEmptyExceptionTest() {
		MyUnsortedList.of().popLast();
	}
	
	@Test
	public void removeTest() {
		MyUnsortedList popExample = testMother.clone();
		popExample.pop();
		MyUnsortedList popLastExample = testMother.clone();
		popLastExample.popLast();
		
		MyUnsortedList popTest = testMother.clone();
		popTest.remove(0);
		MyUnsortedList popLastTest = testMother.clone();
		popLastTest.remove(popLastTest.size()-1);
		
		assertEquals(popExample, popTest);
		assertEquals(popLastExample, popLastTest);
		assertNotEquals(testMother.testMother, popTest);
		assertNotEquals(testMother.testMother, popLastTest);
		
		MyUnsortedList removeMiddle = testMother.clone();
		removeMiddle.remove(3);
		
		assertNotEquals(removeMiddle, testMother.testMother);
		assertEquals(removeMiddle, MyUnsortedList.of(1,2,3,5));
	}
	
	@Test(expected = EmptyListException.class)
	public void removeEmptyExceptionTest() {
		MyUnsortedList.of().remove(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeOutOfBoundsExceptionTest() {
		MyUnsortedList.of(1).remove(4);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeOutOfBoundsTwoExceptionTest() {
		MyUnsortedList.of(1).remove(-4);
	}
	
	@Test
	public void toStringTest() {
		// Ameliorable en parcourant la liste
		String toString = "MyUnsortedList { size = " + testMother.testMother.size()
			+ ", [1, 2, 3, 4, 5] }";
		
		assertEquals(toString, testMother.testMother.toString());
	}
	
	@Test
	public void equalsTest() {
		assertTrue(testMother.testMother.equals(MyUnsortedList.of(1,2,3,4,5)));
		assertFalse(testMother.testMother.equals(MyUnsortedList.of(1,2,3,4)));
	}
}
