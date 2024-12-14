package datastructures;
import java.util.*;
import java.io.*;

public class StringStackImplMain {

	public static void main(String[] args) throws NoSuchElementException {

		StringStackImpl implementation = new StringStackImpl();
		
		System.out.println("size is "+implementation.size()+" ");
		implementation.push("Hello");
		implementation.push("There");
		implementation.printStack(System.out);
		System.out.println("size is "+implementation.size()+" ");

		implementation.push("Andreas");
		System.out.println("size is "+implementation.size()+" ");

		System.out.println(implementation.pop());
		System.out.println("size is "+implementation.size()+" ");

		System.out.println(implementation.peek());
		implementation.push("1");
		implementation.push("2");
		System.out.println("tail is "+implementation.peek());
		implementation.printStack(System.out);
	}

}
