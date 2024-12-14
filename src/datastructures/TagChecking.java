package datastructures;
import java.util.*;
import java.io.*;

public class TagChecking {

	public static void main(String[] args) throws FileNotFoundException {
		StringStackImpl string_stack = new StringStackImpl(); 	// basic variables initialization. first in line the stack
		String file_path=null;									// file path for the file	
		File html_file;											// file variable
		Scanner reader;											//reader for lines
		
		if (args.length == 1) file_path = args[0];				//checking correct input from command line
		else {
			System.out.println("Error in arguments!!! Please input one argument which is "
							  +"the file path of the HTML file you want to check!");
			System.exit(1);
		}
		
		try {
			html_file = new File(file_path);
			reader = new Scanner(html_file);
			String line;
			int open_tag_index; 
			int close_tag_index;
			boolean error_flag=false;
			
			while (reader.hasNextLine()) 
			{ 	
				line = reader.nextLine();
				open_tag_index = line.indexOf("<");
				
				while(open_tag_index >= 0) {
					close_tag_index = line.indexOf(">", open_tag_index+1);
					
					if (!(line.substring(open_tag_index+1).startsWith("/"))) {
						String temp_input = line.substring(open_tag_index+1,close_tag_index);
						if (!temp_input.contains("img")&&!temp_input.contains("br"))
							string_stack.push(temp_input);
					}
					else {
						int endCloseIndex = line.indexOf(">",open_tag_index+1);
						String tag_closure = line.substring(open_tag_index+2,endCloseIndex);
					
						
						if (string_stack.size()>0) {
							if (tag_closure.equals(string_stack.peek())) {
								string_stack.pop();
							}
							else {
								error_flag=true;
								break;
							}
						}
						else {
							error_flag = true;
							break;
							}
						}
					
					
					open_tag_index = line.indexOf("<",close_tag_index+1);
				}
				
				if (error_flag) break;
				
			}
			
			if (!error_flag && string_stack.isEmpty()) {
				System.out.print("The program has valid HTML tags!\n\n");
			}
			else {
				System.out.print("The program has not valid HTML tags!\n\n");
			}
		
			reader.close();
			} catch (FileNotFoundException e) {System.out.println("Please provide correct file path!");System.exit(1);}
	}
}

	