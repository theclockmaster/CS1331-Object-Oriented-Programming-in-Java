import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>{
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public LinkedList() {
			this.head=null;
			this.tail=null;
			this.size=0;
	}
	
	 public Node<T> getHead() {
		 return head;
	 }
	 public Node<T> getTail(){
		 return tail;
	 }
	 
	 public void addAtIndex(T data, int index) {
		 if (index<0 || index>size)
			 throw new IllegalArgumentException("Your index is out of the list bounds");
		 
		 if(data==null)
			 throw new IllegalArgumentException("You cannot add null data to the list");
		 
		 Node<T> newNode = new Node<T>(data); //creating a new node
		 
		 if(head==null)
			 head = newNode;
		 else if (index==0) {
			 newNode.setNext(head);
			 head = newNode;
		 } else {
			 Node<T> prevNode = head;
			 int i = 0;
			 for(i=0; i<index-1 ;i++) {
				 prevNode = prevNode.getNext();
			 }
			 newNode.setNext(prevNode.getNext());
			 prevNode.setNext(newNode); 
		 }
		 
		 if (newNode.getNext()==null) {
			 tail= newNode;
		 }
		 size++;
	 }
	 
	  public void clear() {
		    head = null;
		    tail = null;
		    size = 0;
	  }
	  
	  public boolean isEmpty() {
		    return size == 0;
	  }
	 
	  public int size() {
		    return size;
	  }
	  
	  public T removeAtIndex(int index) {
		  if (index < 0 || index > size - 1) {
		      throw new IllegalArgumentException("Your index is out of the list bounds");
		  }	  
		  Node<T> toRemove;
		  if (index == 0) {
			  toRemove = head;
		      head = head.getNext();
		      if (head == null) tail = null;
		    } else {
		      Node<T> current = head;
		      for (int i = 0; i < index-1; i++) {
		        current = current.getNext();
		      }

		      toRemove = current.getNext();
		      current.setNext(toRemove.getNext());
		      if (current.getNext() == null) tail = current;
		    }
		    size--;
		    return toRemove.getData();
		  }
	  	  
	  public T remove(T data) {
		  if (data == null)
			  throw new IllegalArgumentException("You cannot remove null data from the list");
		  
		  Node<T> toRemove = null;
		  
		  if(head.getData() == data) {
			  toRemove = head;
			  head = head.getNext();
		  } else {
			  Node<T> current = head;
			  
			  while(current!=null) { //iterate until node is found, swap and isolate toRemove Node.
				  if(current.getNext()!=null && current.getNext().getData()==data) {
					  toRemove = current.getNext();
					  current.setNext(toRemove.getNext());
					  if (current.getNext() == null) tail = current;
					  break;
				  }
				  current = current.getNext();
			  }
		  }
		  
		  if (toRemove == null) 
			  throw new NoSuchElementException("The data is not present in the list.");
		  size--;		  
		  return toRemove.getData();
	  }
	
	  public T getAtIndex(int index) {
		    if (index < 0 || index > size - 1) {
		      throw new IllegalArgumentException("Your index is out of the list bounds");
		    }

		    Node<T> current = head;

		    for (int i = 0; i < index; i++) {
		      current = current.getNext();
		    }

		    return current.getData();
		  }
}
