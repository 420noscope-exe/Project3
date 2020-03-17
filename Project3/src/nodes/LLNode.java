package nodes;


public class LLNode<E> {
	
	private E info;
	private LLNode<E> next;
	private LLNode<E> prev;
	
	public LLNode(E info) {
		this.info = info;
		next = null;
	}
	
	public E getInfo() {
		return info;
	}
	
	public void setInfo(E info) {
		this.info = info;
	}
	
	public LLNode<E> getNext() {
		return next;
	}
	
	public void setNext(LLNode<E> next) {
		this.next = next;
	}
	
	public LLNode<E> getPrev(){ //Wes
		return prev;
	}
	
	public void setPrev(LLNode<E> prev) { //Wes
		this.prev = prev;
	}
}
