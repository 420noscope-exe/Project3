package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class LLBasedList<E> implements ListInterface<E> {

	private LLNode<E> head = null;
	private int length = 0;
	
	
	public LLBasedList(){
		
	}
	
	@Override
	public void add(E element) { //Wes
		if(isEmpty()) {
			head = new LLNode<>(element);
			length++;
		}else {
			LLNode<E> currentNode = head;
			int i = 0;
			while(i < length) {
				if(((Comparable)element).compareTo(currentNode.getInfo()) > 0) {
					if(currentNode.getNext() != null) {
						currentNode = currentNode.getNext();
					}else {
						break;
					}
				}else {
					break;
				}
				++i;
			}
			LLNode<E> newNode = new LLNode<E>(element);
			LLNode<E> lastNode = currentNode;
			LLNode<E> nextNode = currentNode.getNext();
			newNode.setPrev(currentNode);	
			newNode.setNext(currentNode.getNext());	
			currentNode.setNext(newNode);
			if(nextNode != null) {
				nextNode.setPrev(newNode);
			}
			length++;
			System.out.println(length + " " + head.getInfo().toString());//test
		}
		
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
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
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void resetIterator() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E getNextItem() {
		// TODO Auto-generated method stub
		return null;
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
