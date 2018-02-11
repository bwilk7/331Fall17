public class Final{
	public static void main(String[] args){
		String numbers = args[0];
		String[] stringArray = numbers.split(",");

		
		double total = 0;
		for(String s : stringArray){
			total += Integer.parseInt(s);
		} 

		System.out.println(total/stringArray.length);
	}
}
