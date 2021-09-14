package abstractclasses;
public class ClassEat extends AbstractClassDemo1{



	@Override
	void eat() {
		//super.eat();
		System.out.println("Inside classEat");
		
	}

	public static void main(String[] args) {
		ClassEat obj1 = new ClassEat();
		obj1.eat();
	}
}