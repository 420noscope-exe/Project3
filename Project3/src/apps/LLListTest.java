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
		

	}

}
