package apps;

import adts.LLBasedList;

public class PerformanceTest {

	public static void main(String[] args) {
		
		int size = 30000;
		int avg = 0;
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
			list.contains(num);
			EndTime = System.nanoTime();
			avg += EndTime - StartTime;
			System.out.println("Time in microseconds to search for random number " + num + " using a linear search: " + (EndTime - StartTime) / 1000 + " microseconds");
		}
		System.out.println("Average time for linear search: " + (avg/5)/1000 + " microseconds");
		System.out.println();
	    System.out.println("Search for " + size);
	    
	    list.setFind(2);
	    avg = 0;
	    for (int i = 0; i < 5; i++) {
	    	int num = (int) (Math.random() * size);
	    	StartTime = System.nanoTime();
	    	list.contains(num);
	    	EndTime = System.nanoTime();
	    	avg += EndTime - StartTime;
	    	System.out.println("Time in microseconds to search for random number " + num + " using a binary search: " + (EndTime - StartTime) / 1000 + " microseconds");
	    }
	    System.out.println("Average time for binary search: " + (avg/5)/1000 + " microseconds");
	    
	}

}
