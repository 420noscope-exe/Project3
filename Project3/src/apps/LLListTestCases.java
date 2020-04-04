package apps;
import adts.LLBasedList;

public class LLListTestCases {

	public static void main(String[] args) {
		LLBasedList<String> list;
		
		System.out.println("Test case 1");
		list = new LLBasedList<String>();
		System.out.println(list.isEmpty() ? "List is empty" : "List is not empty");
		list.add("String");
		System.out.println("String added to list");
		System.out.println(list.isEmpty() ? "List is empty" : "List is not empty");
		
		System.out.println("\nTest case 2");
		list = new LLBasedList<String>();
		list.add("String");
		System.out.println(list);
		list.add("String1");
		System.out.println(list);
		list.add("String2");
		System.out.println(list);
		
		System.out.println("\nTest case 3");
		list = new LLBasedList<String>();
		System.out.println("List contains sassafras: "  + list.contains("sassafras"));
		list.add("guttersnipe");
		System.out.println("List contains sassafras: "  + list.contains("sassafras"));
		list.add("sassafras");
		System.out.println("List contains sassafras: "  + list.contains("sassafras"));
		
		System.out.println("\nTest case 4");
		list = new LLBasedList<String>();
		list.add("C");
		list.add("B");
		list.add("A"); //head
		list.resetIterator();
		System.out.println("After reseting the forward iterator, getNextItem points to: " + list.getNextItem());
		
		System.out.println("\nTest case 5");
		list.resetBackIterator();
		System.out.println("After reseting the back iterator, getPrevItem points to: " + list.getPrevItem());
		
		System.out.println("\nTest case 6");
		list = new LLBasedList<String>();
		System.out.println("Size: " + list.size());
		list.add("String");
		System.out.println("Size: " + list.size());
		list.add("String1");
		list.add("String2");
		System.out.println("Size: " + list.size());
		list.remove("String2");
		System.out.println("Size: " + list.size());
		
		System.out.println("\nTest case 7");
		list = new LLBasedList<String>();
		System.out.println(list.toString());
		list.add("String");
		System.out.println(list);
		list.add("String1");
		System.out.println(list);
		list.add("String2");
		System.out.println(list);
		list.add("String");
		System.out.println(list);
		
		System.out.println("\nTest case 8");
		list = new LLBasedList<String>();
		list.add("Apple");
		list.add("Orange");
		list.add("Banana");
		list.add("Carrot");
		System.out.println(list.get("Apple") + " gotten from the list.");
		
		System.out.println("\nTest case 9");
		list = new LLBasedList<String>();
		list.add("Apple");
		list.add("Peach");
		list.add("Chicken");
		System.out.println("getPrevItem points to: " + list.getPrevItem());
		System.out.println("getPrevItem now points to: " + list.getPrevItem());
		System.out.println("getPrevItem now points to: " + list.getPrevItem());
		list = new LLBasedList<String>();
		list.add("Apple");
		System.out.println("getPrevItem points to: " + list.getPrevItem()); //only item on the list
		
		System.out.println("\nTest case 10");
		list = new LLBasedList<String>();
		list.add("String");
		list.add("String1");
		list.add("String2");
		list.getNextItem(); //set getNextItem to point to second item
		System.out.println("getNextItem points to: " + list.getNextItem());
		System.out.println("getNextItem now points to: " + list.getNextItem()); //Points to last item
		System.out.println("getNextItem is at the last item and loops back to the start of the list: " + list.getNextItem());
		
		System.out.println("\nTest case 11");
		list = new LLBasedList<String>();
		list.add("String");
		list.add("String1");
		list.add("String2");
		System.out.println("Current list:\n" + list);
		System.out.println(list.remove("String2") ? "String2 removed" : "String2 does not exist on list");
		System.out.println("Current list:\n" + list);
		System.out.println(list.get("String2"));
		System.out.println(list.remove("String1000") ? "String1000 removed" : "String1000 does not exist on list");

	}

}
