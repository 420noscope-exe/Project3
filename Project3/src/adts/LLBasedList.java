package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class LLBasedList<E> implements ListInterface<E> {

	private LLNode<E> head = null;
	private LLNode<E> tail = null;
	private int length = 0;
	private LLNode<E> forwardIterator = null;
	
	
	public LLBasedList(){
		
	}
	
	@Override
	public void add(E element) { //Wes
		if(isEmpty()) {
			head = new LLNode<>(element);
			resetIterator();
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
			LLNode<E> tailNode = currentNode;
			LLNode<E> nextNode = currentNode.getNext();
			newNode.setPrev(currentNode);	
			newNode.setNext(currentNode.getNext());	
			currentNode.setNext(newNode);
			if(nextNode != null) {
				nextNode.setPrev(newNode);
			}
			while(tailNode.getNext() != null)
				tailNode = tailNode.getNext();
			tail = tailNode;
			length++;
			System.out.println(length + " " + head.getInfo().toString());//test
		}
		
	}
	
	public boolean find(E element) //Alex
	{
		//Linear search
		int i = 0;
		resetIterator();
		while((((Comparable)element).compareTo(getNextItem()) != 0))
		{
			if(i == length)
				return false;
			i++;
		}
		
		return true;
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
	public boolean contains(E element) { //Alex
		return find(element);
	}

	@Override
	public E get(E element) { //Alex
		if(find(element))
			return forwardIterator.getInfo();
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
