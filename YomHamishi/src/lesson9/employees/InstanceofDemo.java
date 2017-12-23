package lesson9.employees;

import lesson9.employees.Boss;
import lesson9.employees.Employee;
import lesson9.employees.Manager;

public class InstanceofDemo {

	public static void main(String[] args) {
		Employee e = new Boss("a",100);
		
		System.out.println(e instanceof Manager);
		System.out.println(e.getClass() == Manager.class);

		Manager m = (Manager)e;
		System.out.println(m.bonus);
	}

}
