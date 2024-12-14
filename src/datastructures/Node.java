package datastructures;

public class Node<T> {
	
	protected T data; 
	protected Node next = null; 
	
	Node(T data)
	{
		this.data = data; 
	}
	
	public T getData() 
	{
		return this.data;
	}
	
	public Node<T> getNext()
	{
		return this.next; 
	}
	
	public void setData(T data) {
		this.data = data;
	}
	public void setNext(Node<T> next) 
	{
		this.next = next;
	}

}
