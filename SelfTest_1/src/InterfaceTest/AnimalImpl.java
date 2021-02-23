package InterfaceTest;

public class AnimalImpl implements Animal{

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("they do eat!");
		
	}

	@Override
	public void travel() {
		// TODO Auto-generated method stub
		System.out.println("they do travel");
		
	}
	
	public static void main(String args[]){
		AnimalImpl AI = new AnimalImpl();
		AI.eat();
		AI.travel();
	}

}
