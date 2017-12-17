package lesson9a;

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
		System.out.println("B earns "+e2.getSalary());
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
		System.out.println("total salaray = "+totalSalary);
		
//		Employee e4 = e3;
//		System.out.println(e4.description());
//		
//		e4.raiseSalary(5);
//		System.out.println(e4.description());
		//e4.setBonus(10); // Compilation error
		
	}
}
