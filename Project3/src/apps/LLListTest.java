package apps;

import adts.LLBasedList;

public class LLListTest {
	
	private static LLBasedList<String> list = new LLBasedList<>();

	public static void main(String[] args) {
		
		list.add("A");
		System.out.println(list.size());
		list.add("B");
		System.out.println(list.size());
		list.add("C");
		System.out.println(list.size());
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
		System.out.println(list.size());
		
		System.out.print(list);
		
		list.add("Apple");
		//System.out.println(list.find("Apple") ? "Found" : "Not Found");
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
		System.out.println("testing getPrevItem below");
		LLBasedList<String> getPrevTest = new LLBasedList<String>();
		getPrevTest.add("A");
		getPrevTest.add("B");
		getPrevTest.add("C");
		System.out.println(getPrevTest.getPrevItem());
		System.out.println(getPrevTest.getPrevItem());
		System.out.println(getPrevTest.getPrevItem());
		System.out.println(getPrevTest.getPrevItem());
		
		
		LLBasedList<String> find2 = new LLBasedList<String>(2); //Using find2 method also testing remove
		find2.add("Apple");
		System.out.println(find2.size());
		find2.add("Orange");
		System.out.println(find2.size());
		find2.add("Pear");
		System.out.println(find2.size());
		find2.add("Banana");
		System.out.println(find2.size());
		//System.out.println(find2.find("Pear") ? "Found" : "Not Found");
		System.out.println(find2.get("Orange") + " Gotten from list");
		System.out.println(find2);
		System.out.println(find2.remove("Banana") ? "Removed banana from list" : "Banana does not exist on list");
		System.out.println(find2);
		System.out.println(find2.size());
		//System.out.println(find2.find("Banana") ? "Found" : "Not Found");
		System.out.println(find2.remove("Apple") ? "Removed Apple from list" : "Apple does not exist on list");
		System.out.println(find2);
		System.out.println(find2.size());
		System.out.println(find2.remove("Pear") ? "Removed Pear from list" : "Pear does not exist on list");
		System.out.println(find2.size());
		System.out.println(find2.remove("Carrot") ? "Removed Carrot from list" : "Carrot does not exist on list");
		System.out.println(find2.size());
		System.out.println(find2);
		System.out.println(find2.remove("Orange") ? "Removed Orange from list" : "Orange does not exist on list");
		System.out.println(find2.size());
		System.out.println(find2.isEmpty() ? "List is empty" : "List is not empty");
		
	}

}
