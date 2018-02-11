import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Collections;

public class InClass3{
	public static void main(String [] args)
	{
	   try{	
		ArrayList<String> words = new ArrayList();
		ArrayList<String> counts = new ArrayList();
		Scanner file_scanner = new Scanner(new FileInputStream("words.txt"));
		while(file_scanner.hasNextLine())
		{
			words.addAll(Arrays.asList(file_scanner.nextLine().split(" ")));
		}

		HashSet<String> words_set = new HashSet(words);
		for(String s : words_set){
			counts.add(Collections.frequency(words,s) + "; " + s); 
		}
		
	   }
	   catch(FileNotFoundException e){
	    	System.out.println("ERROR");
	   }
	   
	}
}
