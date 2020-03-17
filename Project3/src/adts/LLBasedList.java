package adts;

import interfaces.ListInterface;
import nodes.LLNode;

public class LLBasedList<E> implements ListInterface<E> {

	private LLNode<E> head = null;
	private LLNode<E> tail = null;
	
	@Override
	public void add(E element) { //Wes
		if(isEmpty()) {
			head = new LLNode<>(element);
			tail = head;
		}else {
			LLNode<E> currentNode = tail;
			tail.setNext(new LLNode<>(element));
			tail = tail.getNext();
			tail.setPrev(currentNode);
		}
		
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() { //Wes
		if(isEmpty()) {
			return 0;
		} else {
			int result = 1;
			LLNode<E> currentNode = head;
			while(currentNode.getNext() != null) {
				currentNode = currentNode.getNext();
				result++;
			}
			return result;
		}
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

}
