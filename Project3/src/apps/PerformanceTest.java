package apps;

import adts.LLBasedList;

public class PerformanceTest {

	public static void main(String[] args) {
		
		int size = 30000;
		LLBasedList<Integer> list = new LLBasedList<>();
		for (int i = 0; i < size; i++) {
            		list.add(i);
        	}
			
		long StartTime = System.nanoTime();
		long EndTime = System.nanoTime();
	
		System.out.println("List of " + size + " random numbers");
		
		for (int i = 0; i < 5; i++) {
			int num = (int) (Math.random() * size);
			StartTime = System.nanoTime();
			list.find(num);
			EndTime = System.nanoTime();
			
			System.out.println("Time in microseconds to search for random number " + num + " using a linear search: " + (EndTime - StartTime) / 1000 + " microseconds");
		}
		
		System.out.println();
	    System.out.println("Search for " + size);
	    
	    for (int i = 0; i < 5; i++) {
	    	int num = (int) (Math.random() * size);
	    	StartTime = System.nanoTime();
	    	list.find2(num);
	    	EndTime = System.nanoTime();
	    	
	    	System.out.println("Time in microseconds to search for random number " + num + " using a binary search: " + (EndTime - StartTime) / 1000 + " microseconds");
	    }
	    
	}

}
