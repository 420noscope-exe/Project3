package adts;

import java.lang.reflect.Array;

import interfaces.ListInterface;
import nodes.LLNode;

public class LLBasedList<E> implements ListInterface<E> {

	private LLNode<E> head = null;
	private LLNode<E> tail = null;
	private int length = 0;
	private LLNode<E> forwardIterator = null;
	private LLNode<E> backIterator = null;
	private LLNode<E> foundItem = null;
	private int findMethod = 1;
	private boolean changed = false;
	private LLNode<E>[] array;
	
	public LLBasedList(){
		
	}
	
	public LLBasedList(int findMethod)
	{
		if(findMethod == 2)
			this.findMethod = 2;
		else
			this.findMethod = 1;
	}
	
	@Override
	public void add(E element) { //Wes
		length++;
		if(isEmpty()) {
			head = new LLNode<>(element);
			tail = head;
			resetIterator();
		}else {
			LLNode<E> currentNode = head;
			if (((Comparable)element).compareTo(currentNode.getInfo()) <= 0) {	// If element comes before head
				head = new LLNode<E>(element);
				head.setNext(currentNode);
				currentNode.setPrev(head);
			}
			else {
				int i = 0;
				while(i < length) {
					if(((Comparable)element).compareTo(currentNode.getInfo()) > 0) {	// If element is greater than
						if(currentNode.getNext() != null) {	// and if not last node
							currentNode = currentNode.getNext();	// check next node
						}else {	// and if last node
						break;
						}
					}else {
						currentNode = currentNode.getPrev();
						break;
					}
					++i;
				}
				LLNode<E> newNode = new LLNode<E>(element);
				LLNode<E> tailNode = currentNode;
				LLNode<E> nextNode = currentNode.getNext();
				newNode.setPrev(currentNode);	
				newNode.setNext(currentNode.getNext());	
				currentNode.setNext(newNode);
				changed = true;
				if(nextNode != null) {
					nextNode.setPrev(newNode);
				}
				while (tailNode.getNext() != null) {
					tailNode = tailNode.getNext();
					tail = tailNode;
				}
				resetBackIterator();
			}
		}
	}
	
	public boolean find(E element)
	{
		if(findMethod == 1)
			return find1(element);
		if(findMethod == 2)
			return find2(element);
		return false;
	}
	
	public boolean find1(E element) //Alex
	{
		//Linear search
		foundItem = null;
		int i = 0;
		resetIterator();
		while((((Comparable)element).compareTo(getNextItem()) != 0))
		{
			if(i == length)
				return false;
			i++;
		}
		foundItem = forwardIterator;
		resetIterator();
		return true;
	}
	public boolean find2(E element) {
		// Make an array.
		
		// Put the linked list in the array.
		foundItem = null;
		resetIterator();
		int i = 0;
		if(changed)
		{
			array = (LLNode<E>[])Array.newInstance((head.getClass()), length);//(LLNode<E>[])new Object[length];//(LLNode<E>[]) new Object[length];	// This is from the first test. `LLode<E>[] array = new LLNode<E>[length]` generates the message: "Cannot create a generic array of LLNode<E>".
		while (forwardIterator.getNext() != null) {
			array[i++] = forwardIterator.getNext();//.getInfo();
			forwardIterator = forwardIterator.getNext();
		}
		changed = false;
		}
		int low = 0,
			high = array.length - 1,
			mid = (int)( ( high + low ) / 2);
		/*
		int turnCount = 1;							// Test code
		System.out.println("Turn " + turnCount++);	// Test code
		System.out.println("Low: " + low);			// Test code
		System.out.println("Mid: " + mid);			// Test code
		System.out.println("High: " + high);		// Test code
		System.out.println();						// Test code
		*/
		// Loop while the high point is not less than the low point.
		while ( !(high < low) ) {
			// Compare the element to the mid-point.
			// If the element is more than the mid-point, then the low point becomes one above the mid-point.
			if ( ( ( (Comparable<E>) element ) .compareTo (array[mid].getInfo()) ) > 0 ) {
				//System.out.println("Turn " + turnCount++);			// Test code
				low = mid + 1;
				/*
				mid = (int)( ( high + low ) / 2 ); 						// Test code
				System.out.println("Low: " + low);						// Test code
				System.out.println("Mid: " + ( (low + high) / 2) );		// Test code
				System.out.println("High: " + high);					// Test code
				System.out.println();									// Test code
				*/
			}
			// If the element is equal to the mid-point, then return true.
			else {
				if ( ( ( (Comparable<E>) element ) .compareTo (array[mid].getInfo()) ) == 0 )
				{
					foundItem = array[mid];
					return true;
				}
				// If the element is less than the mid-point, then the high point becomes one below the mid-point.
				else {
					//System.out.println("Turn " + turnCount++);	// Test code
					high = mid - 1;
					/*
					mid = (int)( ( high + low ) / 2 );				// Test code
					System.out.println("Low: " + low);				// Test code
					System.out.println("Mid: " + mid);				// Test code
					System.out.println("High: " + high);			// Test code
					System.out.println();							// Test code
					*/
				}
			}
			// Reposition the mid-point.
			mid = (int)( ( high + low ) / 2 );	//	COMMENT THIS OUT DURING TESTING; DO NOT DELETE THIS!
		}
		return false;
	}
	@Override
	public boolean remove(E element) {
		if(find(element))
		{
			changed = true;
			if(foundItem.getPrev() != null)
				foundItem.getPrev().setNext(foundItem.getNext());
			if(foundItem.getNext() != null)
				foundItem.getNext().setPrev(foundItem.getPrev());
			return true;
		}
		return false;
	}

	@Override
	public int size() { //Wes
		return length;
	}

	@Override
	public boolean isEmpty() { //Wes
		if(head == null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean contains(E element) { //Alex
		return find(element);
	}

	@Override
	public E get(E element) { //Alex
		if(find(element))
			return foundItem.getInfo();
		else
			return null;
	}

	@Override
	public void resetIterator() { //Alex
		if(head == null)
			return;
		forwardIterator = new LLNode<E>(head.getInfo()); //Just placeholder info doesn't matter what's inside
		forwardIterator.setNext(head);
	}

	@Override
	public E getNextItem() {
		if(forwardIterator == null)
			return null;
		forwardIterator = forwardIterator.getNext();
		if(forwardIterator == tail)
		{
			resetIterator();
			return tail.getInfo();
		}
		return forwardIterator.getInfo();
	}
	
	public void resetBackIterator() { //Lina
		if(tail == null)
			return;
		backIterator = new LLNode<E>(tail.getInfo()); 
		backIterator.setPrev(tail);
	}
	
	public E getPrevItem() { //Lina
		if(backIterator == null)
			return null;
		backIterator = backIterator.getPrev();
		if(backIterator == head)
		{
			resetBackIterator();
			return head.getInfo();
		}
		return backIterator.getInfo();
	}
	
	@Override
	public String toString() { //Wes
		String result = "";
		LLNode<E> currentNode = head;
		while(currentNode.getNext() != null) {
			result = result + currentNode.getInfo().toString() + "\n";
			currentNode = currentNode.getNext();
		}
		result += currentNode.getInfo().toString() + "\n";
		return result;
	}
	
}