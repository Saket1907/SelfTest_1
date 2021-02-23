class PrintText extends Thread {
	public synchronized void run() {
		System.out.println("In method testThreadOne");
		
		for(int i = 0; i <= 5; i++){
			System.out.print("In method testThreadOne :  "+i);
		}
	}
}

class PrintTextSecond extends Thread {
	public synchronized void run() {
		System.out.println("In method testThreadSecond");
		
		for(int i = 0; i <= 5; i++){
			System.out.println("In method testThreadSecond : "+i);
		}
	}
}

public class ThreadTest{

	public static void main(String[] args) {
		
		System.out.println("Printing result!");
		
		PrintText PT = new PrintText();
		PrintTextSecond PTS = new PrintTextSecond();
		
		PT.start();
		PTS.start();
     
	}

}
