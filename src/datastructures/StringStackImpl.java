package datastructures;
import java.util.*;
import java.io.*;

public class StringStackImpl implements StringStack{
	
	private List<String> list;
	private int size;
	
	public StringStackImpl() 
	{
		this.list = new List<String>();
		this.size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	@Override
	public void push(String item) {
		this.list.insertAtBack(item);
		this.size++;// TODO Auto-generated method stub
		
	}

	@Override
	public String pop() throws NoSuchElementException{
		try {
			String item = this.list.removeFromBack();
			this.size--;
			return item;

		} catch (NoSuchElementException e) 
		{
			return "Error stack empty";
			//throw new NoSuchElementException();
			}
	}

	@Override
	public String peek() throws NoSuchElementException {
			try 
				{	
				String item = this.list.getTail();
				return item;
				} 
			catch (NoSuchElementException e) 
				{
				String item_error = "error stack empty";
				return item_error;}
		
	}
	

	@Override
	public void printStack(PrintStream stream) {
	
	if (this.isEmpty()) 
		{
		stream.println("String Stack EMPTY!!!!");
		}
	else 
		{
		stream.println(this.list.toString());// TODO Auto-generated method stub
		}
	}

	@Override
	public int size() {
		return this.size;
	}
	}
