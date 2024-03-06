package datastruct;

public class MyUnsortedListTestMother {

	public MyUnsortedList<Integer> testMother;
	
	MyUnsortedListTestMother(){
		testMother = MyUnsortedList.of(1,2,3,4,5);
	}
	
	public MyUnsortedList<Integer> clone(){
		return MyUnsortedList.of(1,2,3,4,5);
	}
	
}
