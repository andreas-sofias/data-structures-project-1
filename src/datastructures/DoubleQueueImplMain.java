package datastructures;
import java.util.*;
import java.io.*;

public class DoubleQueueImplMain {

	public static void main(String[] args) throws NoSuchElementException {

		DoubleQueueImpl implementation = new DoubleQueueImpl();
		double z = implementation.get();
		System.out.println("size is "+implementation.size()+" ");
		implementation.put(1.2);
		implementation.put(3.5);
		implementation.printQueue(System.out);
		System.out.println("size is "+implementation.size()+" ");

		implementation.put(14.88);
		System.out.println("size is "+implementation.size()+" ");

		System.out.println(implementation.get());
		System.out.println("size is "+implementation.size()+" ");

		System.out.println(implementation.peek());
		implementation.put(1);
		implementation.put(2);
		System.out.println("tail is "+implementation.peek());
		double x = implementation.get();
		double y = implementation.get();
		implementation.printQueue(System.out);
	}

}
