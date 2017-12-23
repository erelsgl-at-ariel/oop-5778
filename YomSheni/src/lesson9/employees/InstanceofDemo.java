package lesson9.employees;

public class InstanceofDemo {

	public static void main(String[] args) {
		Employee e = new Boss("a",100);
		
		System.out.println(e instanceof Manager);
		System.out.println(e.getClass() == Manager.class);

		Manager m = (Manager)e;
		System.out.println(m.bonus);
	}

}
