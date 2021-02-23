/**
 * 
 * @author saku.isaket
 *
 */
public class AddTestAlternate {
	public static void main(String args[]){
		int First_Number = 123456789;
		int Second_Number = 234567890;
		
		System.out.print("First number in array : ");
		int[] First_Number_Array = Integer.toString(First_Number).chars().map(c -> c-='0').toArray();
		for(int i : First_Number_Array){
			System.out.print(i);
			System.out.print(" ");
		}
		
		System.out.println("");
		
		System.out.print("Second number in array : ");
		int[] Second_Number_Array = Integer.toString(Second_Number).chars().map(c -> c-='0').toArray();
		for(int j : Second_Number_Array){
			System.out.print(j);
			System.out.print(" ");
		}
	}

}
