package datastructures;
import java.io.*;
import java.util.*;

public class NetProfit {

	public static void main(String[] args) {
		DoubleQueueImpl stocks = new DoubleQueueImpl();// TODO Auto-generated method stub
		DoubleQueueImpl prices = new DoubleQueueImpl();
		double stock_price;
		double revenue = 0.0;
		int stock_amount;
		int total_stocks = 0;
		boolean errorFlag = false;
		String file_path = null;
		File input_file; 
		Scanner reader;
		
		if (args.length == 1) file_path = args[0];				//checking correct input from command line
		else {
			System.out.println("Error in arguments!!! Please input one argument which is "
							  +"the file path of the .txt file you want to check!");
			System.exit(1);
		}		
		
		try {
			input_file = new File(file_path);
			reader = new Scanner(input_file);
			String line;
			
			while (reader.hasNextLine()) {
				line = reader.nextLine();
				String[] input_tokens = line.split("\\s+");
				String choice = input_tokens[0];
				stock_amount = Integer.parseInt(input_tokens[1]);
				stock_price = Double.parseDouble(input_tokens[3]);
				if (stock_price<0 || stock_amount<0) 
				{
					errorFlag=true;
					break;
				}
				if (choice.equalsIgnoreCase("buy")) {
					total_stocks += stock_amount;
					stocks.put(stock_amount);
					prices.put(stock_price);
					stocks.printQueue(System.out);
					prices.printQueue(System.out);
					System.out.println();
				}
				else if (choice.equalsIgnoreCase("sell")) 
				{
					if (stock_amount>total_stocks) {
						errorFlag=true;
						System.out.println("You can't sell an amount you don't have!");
						break;
					}
					else {
						while (stock_amount > 0) {
							int stock_at_time_t = (int)stocks.peek();
							if (stock_at_time_t > stock_amount) {
								int difference = stock_at_time_t-stock_amount;
								stocks.modify((double)difference);
								double price_at_time_t = prices.peek();
								System.out.print("revenue: "+stock_amount+"*("+stock_price+"-"+price_at_time_t+")\n");
								stocks.printQueue(System.out);
								prices.printQueue(System.out);
								System.out.println();

								revenue += stock_amount * (stock_price - price_at_time_t);
								stock_amount -= stock_amount;
							}
							else {
								stock_at_time_t = (int)stocks.get();
								double price_at_time_t = prices.get();
								System.out.print("revenue: "+stock_at_time_t+"*("+stock_price+"-"+price_at_time_t+")\n");
								stocks.printQueue(System.out);
								prices.printQueue(System.out);
								System.out.println();

								revenue += stock_at_time_t*(stock_price - price_at_time_t);
								stock_amount -= stock_at_time_t;		
							}
						}	
					}
				}
				else {
					errorFlag=true;
					break;
				}
			}
			if (errorFlag) {System.out.println("You messed up the parameters.Pleased give correct input");System.exit(0);}
			System.out.printf("The net profit is %.1f \n",revenue);
			reader.close();
		} catch (FileNotFoundException e) {System.out.println("Please provide correct file path!");System.exit(1);}
		  catch (NumberFormatException e) {System.out.println("YOU FUCKED UP!PUT THE CORRECT INPUT GODDAMIT");System.exit(1);}
		  catch (ArrayIndexOutOfBoundsException e) {System.out.println("MESSED UP");System.exit(0);}
		
	}

}
