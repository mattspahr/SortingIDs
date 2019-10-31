import java.io.*;
import java.util.*;

public class Driver {

	 

	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in);
		ArrayList<String> idList = new ArrayList<String>();
		
		System.out.println("Please enter list. Enter key with no input to end.");
		String input;
		
		while((input = keyboard.nextLine()).length() > 0) {
			
			idList.add(input);

		}
		
		int c = 1;
		for (int i = 0; i < idList.size() - 1; i++) {
			
			if (idList.get(i).compareTo(idList.get(c)) > 0) {
				Collections.swap(idList, i, c);
			}
			
		}
		
		for (int i = 0; i < idList.size(); i++) {
				System.out.println(idList.get(i));
		}
	}

}