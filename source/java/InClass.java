import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Collections;
import java.util.Map;

public class InClass{
	private String file_name;
	private HashMap<String,Integer> wordCount;
	
	public InClass(){
		wordCount = new HashMap<String,Integer>(); 
	}

	public HashMap<String,Integer> read_file(String file_name){
		try{
			Scanner file_reader = new Scanner(new FileInputStream(file_name));
			while(file_reader.hasNextLine()){
				String [] words = file_reader.nextLine().split(" ");
				for(String wt: words){
					String w = wt.trim();
					if(wordCount.containsKey(w)){
						wordCount.put(w,wordCount.get(w) + 1);
					}
					else{
						wordCount.put(w,1);
					}
					//System.out.println(w);
				}
			}
		}
		catch(Exception e){
			System.err.println("File Not Found");
		}
		return wordCount;
	}

	public static void main(String[] args){
		InClass ic = new InClass();
		HashMap<String,Integer> wc = ic.read_file("words.txt");
		HashMap<String,Integer> sorted = new HashMap<String,Integer>();
		for(int i = 0; i < 10; i++){
			sorted.put(Integer.toString(i),0);
		}
		for(String k: wc.keySet()){
			if(wc.get(k) > Collections.min(sorted.values())){
				String to_remove = "";
				for(Map.Entry<String,Integer> pair: sorted.entrySet()){
					if(pair.getValue() == Collections.min(sorted.values())){
						to_remove = pair.getKey();
					}
				}
				sorted.remove(to_remove);
				sorted.put(k,wc.get(k));
			}
		}
		for(String k: sorted.keySet()){
			System.out.println(k + " " + sorted.get(k));
		}
	}


	
}
