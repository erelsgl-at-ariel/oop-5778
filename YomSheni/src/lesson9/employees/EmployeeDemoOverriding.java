package lesson9.employees;

import java.util.*;

/**
 * Demonstrates how method overriding works with the Employee hierarchy.
 * @author erelsgl
 */
public class EmployeeDemoOverriding {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		
		Employee e1 = new Employee("A", 100);
		System.out.println("A earns "+e1.getSalary());
		employees.add(e1);
		
		Programmer e2 = new Programmer("B", 100);
		e2.delLines(10);
		Employee e2x = e2;
		//e2x.delLines(10); // compiler error
		System.out.println("B earns "+e2x.getSalary());
		employees.add(e2);
		
		Manager e3 = new Manager("C", 100);
		e3.setBonus(5);
		System.out.println("C earns "+e3.getSalary());
		employees.add(e3);

		
		double totalSalary = 
			employees
			.stream()
			.mapToDouble(e -> e.getSalary())
			.reduce( (x,y) -> x+y )
			.getAsDouble();
		System.out.println("total salary = "+totalSalary);
		
//		Employee e5 = new Manager("abc",500);
//		Manager m5 = (Manager)e5;
//		//e5.setBonus(5);
//		m5.setBonus(5);
//		Programmer p5 = (Programmer)e5;
//		//e5.addLines(10);
//		p5.addLines(10);
		
		
	}
}
