
public class Node<T>{
	private T data;
	private Node<T> next;
	
	public Node(T d, Node next) {
		this.data = d;
		this.next = next;
	}
	
	public Node(T da) {
		this.data = da;
		this.next = null;
	}
	
	public T getData() {
		return data;
	}

	 public Node<T> getNext() {
	        return next;
	    }
	 
	 public void setData(T data) {
	        this.data = data;
	    }
	 
	 public void setNext(Node<T> next) {
	        this.next = next;
	    }
}
