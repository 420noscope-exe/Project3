package apps;

import adts.LLBasedList;

public class LLListTest {
	
	private static LLBasedList<String> list = new LLBasedList<>();

	public static void main(String[] args) {
		
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		list.add("F");
		list.add("G");
		
		list.add("A");
		list.add("F");
		list.add("E");
		list.add("D");
		list.add("C");
		list.add("B");
		list.add("G");
		
		
		
		list.add("A");
		list.add("C");
		list.add("F");
		list.add("G");
		list.add("B");
		list.add("D");
		list.add("E");
		
		System.out.print(list);
		
		list.add("Apple");
		System.out.println(list.find("Apple") ? "Found" : "Not Found");
		String getTest = list.get("Apple");
		System.out.println("Got " + getTest + " from list.");
		System.out.println("List contains Apple: " + list.contains("Apple"));
		
		LLBasedList<String> getNextTest = new LLBasedList<String>();
		getNextTest.add("A");
		getNextTest.add("B");
		getNextTest.add("C");
		System.out.println(getNextTest.getNextItem());
		System.out.println(getNextTest.getNextItem());
		System.out.println(getNextTest.getNextItem());
		System.out.println(getNextTest.getNextItem()); //Loop back to start of list
		
		//getPrevItem test - buggy - shows all null values during testing
		System.out.println("testing previous below");
		LLBasedList<String> getPrevTest = new LLBasedList<String>();
		getPrevTest.add("A");
		getPrevTest.add("B");
		getPrevTest.add("C");
		System.out.println(getPrevTest.getPrevItem());
		System.out.println(getPrevTest.getPrevItem());
		System.out.println(getPrevTest.getPrevItem());
		System.out.println(getPrevTest.getPrevItem());

	}

}
