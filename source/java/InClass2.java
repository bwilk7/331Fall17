import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

public class InClass2{
	
	public static void main(String [] args)
	{
		try{
			LinkedList<String> words = new LinkedList();
			Scanner file_scanner = new Scanner(new FileInputStream("words.txt"));
			HashMap<String,Integer> counts = new HashMap();			
			TreeMap<Integer, LinkedList<String>> final_counts = new TreeMap();
			while(file_scanner.hasNextLine()){
				words.addAll(Arrays.asList(file_scanner.nextLine().split(" ")));
			}	
			Collections.sort(words);

			int count = 0;
			String temp = "";
			for(String s: words){
				if(s.equals(temp)){
					count++;
				}
				else{
					counts.put(temp,count);
					count = 1;
				}
				temp = s;
			}
			for(String s: counts.keySet())
			{
				if(!final_counts.containsKey(counts.get(s)))
				{
					final_counts.put(counts.get(s),  new LinkedList<String>());
				}
				final_counts.get(counts.get(s)).add(s);
			}	
			for(Integer i: final_counts.keySet()){
				System.out.println(final_counts.get(i).get(0) + " " +  i);
			}
			
		}
		catch(FileNotFoundException e){
			System.err.println("ERROR");
		}
	}
}
