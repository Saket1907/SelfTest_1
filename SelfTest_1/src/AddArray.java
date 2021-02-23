
public class AddArray {

	public static void main(String[] args) {
		int intArray[] = {12, 43, 42, 45, 14, 76, 99, 00};
		int sumIndex = 0;
		System.out.println("Length of intArray[] : "+intArray.length);
		for(int i = 0; i < intArray.length - 1; i++){
			sumIndex = intArray[i] + intArray[i + 1];
			System.out.println("Sum of sumIndex : "+sumIndex);
		}

	}

}
