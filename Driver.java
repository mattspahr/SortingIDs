import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
	
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Integer> numIdList = new ArrayList<Integer>();
		ArrayList<String> stringIdList = new ArrayList<String>();
		ArrayList<String> idList = new ArrayList<String>();
		
		/*
			Take user input and build lists
		*/
		System.out.println("Please enter list. Enter key with no input to end.");
		String input;
		while((input = keyboard.nextLine()).length() > 0) {
			
			try {
						
				int numId = Integer.parseInt(input.trim());
				numIdList.add(numId);
						
			} catch(NumberFormatException e) {
						
				stringIdList.add(input);			
			}
		}	
		
		// Bubble Sort ArrayList<Integer> numIdList
		int size = numIdList.size();
		for (int i = 0; i < size - 1; i++) {
			
			for (int j = 0; j < size - 1 - i; j++) {
			
				if (numIdList.get(j) > numIdList.get(j + 1)) {
					Collections.swap(numIdList, j , j + 1);	
				}
			}
		}
		
		// Bubble Sort ArrayList<String> stringIdList
		size = stringIdList.size();
		for (int i = 0; i < size - 1; i++) {
			
			for (int j = 0; j < size - 1 - i; j++) {
				
				if (stringIdList.get(j).compareTo(stringIdList.get(j + 1)) > 0) {
					Collections.swap(stringIdList, j , j + 1);	
				}	
			}
		}
		
		/*
			Build idList from numIdList and stringIdList, mainting the sorted order
		*/
		size = numIdList.size() + stringIdList.size();
		for (int i = 0; i < size; i++) {
		
			for (int j = 0; j < numIdList.size(); j++) {
				idList.add(numIdList.get(j).toString());
			}	
			
			for (int k = 0; k < stringIdList.size(); k++) {
				idList.add(stringIdList.get(k));	
			}	
		}		
		
		/* 
			Write idList to output.csv
		*/
		try {
			FileWriter csvWriter = new FileWriter("data/output.csv");
			String c = ",";
			for (int i = 0; i < size; i++) {
				csvWriter.append(idList.get(i));
				csvWriter.append(c);
			}
			csvWriter.flush();
			csvWriter.close();
			System.out.println("Data written to data/output.csv");
		} catch (IOException e) {
			System.out.println("Error");	
		}
	}
}	