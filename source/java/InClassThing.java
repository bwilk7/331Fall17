import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;


public class InClassThing{

  public static void main(String[] args){

    try{
      Scanner file = new Scanner( new FileInputStream("words.txt"));
      ArrayList<String> words = new ArrayList<String>();
      while(file.hasNextLine())
        {
            String line = file.nextLine();
            words.addAll(Arrays.asList(line.split(" ")));
        }

      for(String word : words)
      {
        System.out.println(word);
      }
    }
    catch(Exception e)
    {
      System.err.println(e.getMessage());
    }
  }
}
