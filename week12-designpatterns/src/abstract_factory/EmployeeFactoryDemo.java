package abstract_factory;

import java.util.*;

import employees.Employee;

public class EmployeeFactoryDemo {
	
	public static void addEmployees(List<Employee> employees, EmployeeFactory factory) {
		employees.add(factory.newEmployee("A", 5));
		employees.add(factory.newEmployee("B", 15));
		employees.add(factory.newEmployee("C", 25));
	}

	public static void main(String[] args) {
		List<Employee> employees;
		
		employees = new ArrayList<>();
		addEmployees(employees, new CapitalistEmployeeFactory());
		System.out.println(employees);
		
		employees = new ArrayList<>();
		addEmployees(employees, new SocialistEmployeeFactory());
		System.out.println(employees);
		
		employees = new ArrayList<>();
		addEmployees(employees, new CommunistEmployeeFactory());
		System.out.println(employees);
	}

}
