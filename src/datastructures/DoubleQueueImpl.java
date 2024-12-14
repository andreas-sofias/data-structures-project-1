package datastructures;
import java.io.PrintStream;
import java.util.NoSuchElementException; 

public class DoubleQueueImpl implements DoubleQueue{
	private List<Double> queue;
	private int size;
	
	
	public DoubleQueueImpl() {
		this.queue = new List<Double>();
		this.size = 0;
	}
	/**
	 * @return true if the queue is empty
	 */
	public boolean isEmpty() {
		return this.queue.isEmpty();
	}

	/**
	 * insert a double to the queue
	 */
	public void put(double item) {
		this.queue.insertAtFront(item);
		this.size++;		
	}

	public void modify(double data) {
		queue.modifyTail(data);
	}
	
	public double get() throws NoSuchElementException {
		try {
			double item = this.queue.removeFromBack();
			this.size--;
			return item;

		} catch (NoSuchElementException e) 
		{
			 System.out.println("queue empty");
			 return 0;
			}		
	}

	/**
	 * return without removing the oldest item of the queue
 	 * @return oldest item of the queue
	 * @throws NoSuchElementException if the queue is empty
	 */
	public double peek() throws NoSuchElementException {
		try 
		{	
		double item = this.queue.getTail();
		return item;
		} 
	catch (NoSuchElementException e) 
		{
		System.out.println("queue empty");
		return 0.0;
		}

	}


	/**
	 * print the elements of the queue, starting from the oldest 
         * item, to the print stream given as argument. For example, to 
         * print the elements to the
	 * standard output, pass System.out as parameter. E.g.,
	 * printQueue(System.out);
	 */
	public void printQueue(PrintStream stream)  {
		if (this.isEmpty()) {
			stream.println("Double queue is empty!");
		}
		else {
			stream.println(this.queue.toString());// TODO Auto-generated method stub
		}
	}

	/**
	 * return the size of the queue, 0 if it is empty
	 * @return number of elements in the queue
	 */
	public int size()  {
		return this.size;
	}
}
