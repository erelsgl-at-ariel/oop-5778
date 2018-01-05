package factory;

import java.util.*;

import employees.Employee;

public class EmployeeFactoryDemo {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(EmployeeFactory.newEmployee("A", 5));
		employees.add(EmployeeFactory.newEmployee("B", 15));
		employees.add(EmployeeFactory.newEmployee("C", 25));
		System.out.println(employees);
	}

}
