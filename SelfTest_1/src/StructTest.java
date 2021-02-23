import java.sql.Array;
import java.sql.Struct;

public class StructTest {

	public static void main(String[] args) {
		Object[] testStructArray = new Object[]{
				1, 2, 3, 4, 5, 6, 7, 8, 9, 10
		};
		for(int i = 0; i < testStructArray.length; i++){
			System.out.println("Inside Loop : " +testStructArray[i]);
		}
		
		Struct A {
			int testStructArrayTest = (Struct)testStructArray.length;
		}
         
	}

}
