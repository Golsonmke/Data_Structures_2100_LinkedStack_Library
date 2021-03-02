package assign3LS;

import java.util.*;


/*** COSC 2100 –Spring 2021
 * Assignment#3
 * Use tacks to implement the book check-in process at a library
 *  @author Gary Olson
 * 
***/

public class LibraryDriver {

	public static void main(String[] args) {
		
		//Display title and function of program
		System.out.println("Milwaukee Public Library Book Check-in Program");
		System.out.print("***********************************************");
		System.out.println();
		System.out.println("Enter two letters for the genre followed by a three-digit number");
		System.out.println("CL (classic), FI (fiction), NF (non-fiction), YA (young adult)");
		System.out.println();
		
		//prompt user for call numbers of the returned books
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the call number of the returned book or press X to exit:");
		String callNum = in.next();
		
		//Create a linked Stack for the user entered books 
		LinkedStack<String> bookList = new LinkedStack<String>();
		
		
		//Check if user entered 'X' and no books were returned
		while(callNum.charAt(0) == 'X' || callNum.charAt(0) == 'x' && bookList.isEmpty() ) {
			
			System.out.println("No books returned today. Good Bye!");
			break;			
		} 
		
		//Check if user  entered 'X' or entered another book and push book to top of stack.
		while(callNum.charAt(0) != 'X' || callNum.charAt(0) != 'x' && bookList.isEmpty()) {
			
			if(callNum.charAt(0) == 'X' || callNum.charAt(0) == 'x') {
				break;
			}
				
			bookList.push(callNum);
			System.out.println("Enter the call number of the next returned book or press X to exit:");
			callNum = in.next();
			
			
		}
		//Print a line for spacing
		System.out.println("****************************************************");
		bookSort(bookList);
		
		//close scanner
		in.close();
	}
	//Read call numbers from stack and let user know what shelf each book should go based on genre
	public static void bookSort(LinkedStack<String> bookList) {
		String classic = "CL";
		String fiction = "FI";
		String nonFiction = "NF";
		String youngAdult = "YA";
		
		int clCount = 0;
		int fiCount = 0;
		int nfCount = 0;
		int yaCount = 0;
		int inCount = 0;
			
		
		for(int i = 0; i < bookList.size(); i++) {
			
			String book = bookList.top();
			
			 while(book != null && !bookList.isEmpty()) {
					
					if(book.startsWith(classic)) {
						System.out.println("Call No. " + book + " belongs to the Classic shelf");
						clCount++;
					}
					if(book.startsWith(fiction)) {
						System.out.println("Call No. " + book + " belongs to the Fiction shelf");
						fiCount++;
					}
					if(book.startsWith(nonFiction)) {
						System.out.println("Call No. " + book + " belongs to the Non-Fiction shelf");
						nfCount++;
					}
					if(book.startsWith(youngAdult)) {
						System.out.println("Call No. " + book + " belongs to the Young Adult shelf");
						yaCount++;
					}
					if (!book.startsWith(classic) && !book.startsWith(fiction) && !book.startsWith(nonFiction) && !book.startsWith(youngAdult)){			
							System.out.println("Call No. " + book + " belongs to the Independent shelf");
							inCount++;
					}
					bookList.pop();
					if(book != null) {
						break;	
					}
							
				}
			
		}
			
		
		System.out.println();
		System.out.println("BOOKS CHECK-IN REPORT");
		System.out.println("Checked in " + bookList.size() + " books today-");
		System.out.println("Classic: " + clCount);
		System.out.println("Fiction: " +  fiCount);
		System.out.println("Independent: " + inCount);
		System.out.println("Non-Fiction: " + nfCount);
		System.out.println("Young Adult: " + yaCount);
		
	}
	
	
	
}
