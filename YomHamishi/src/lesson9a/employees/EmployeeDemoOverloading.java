package lesson9a.employees;

import java.util.*;

import lesson9.employees.Employee;
import lesson9.employees.Manager;
import lesson9.employees.Programmer;

/**
 * Demonstrates that method overloading does NOT work well with the Employee hierarchy.
 * 
 * NOTE: This is not a good programming example; it only comes to emphasize the difference
 * between overriding and overloading.
 * 
 * Credit: Dane Cameron, "A software engineer learns Java and OOP", chapter on inheritance.
 * 
 * @author erelsgl
 */
public class EmployeeDemoOverloading {
	
	// The following three methods are *overloaded* (not *overriden*)
	private static double getSalary(Employee e) {
		return e.salary;
	}
	
	private static double getSalary(Manager e) {
		return e.salary + e.bonus;
	}
	
	private static double getSalary(Programmer e) {
		return e.salary - e.linesWritten/10;
	}
	
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		
		Employee e1 = new Employee("A", 100);
		System.out.println("A earns "+getSalary(e1));
		employees.add(e1);

		Programmer e2 = new Programmer("B", 100);
		e2.delLines(10);
		System.out.println("B earns "+getSalary(e2));
		employees.add(e2);

		Manager e3 = new Manager("C", 100);
		e3.setBonus(5);
		System.out.println("C earns "+getSalary(e3));
		employees.add(e3);
		
		Manager e3sup = e3.getSupervisor();

		Employee e4 = e3;
		System.out.println("C earns "+getSalary(e4));

		Employee e4sup = e4.getSupervisor();
		
		double totalSalary = 
			employees
			.stream()
			.mapToDouble(e -> getSalary(e))
			.reduce((x,y)->x+y)
			.getAsDouble();
		System.out.println("total salaray = "+totalSalary);
	}
}
