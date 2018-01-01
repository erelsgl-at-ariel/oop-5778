package abstract_factory;

import java.util.*;

import employees.Employee;

public class EmployeeFactoryDemo {
	
	public static void addEmployees(List<Employee> employees, EmployeeFactory factory) {
		employees.add(factory.newEmployee(EmployeeRank.SIMPLE, "A"));
		employees.add(factory.newEmployee(EmployeeRank.MANAGER, "B"));
		employees.add(factory.newEmployee(EmployeeRank.PROGRAMMER, "C"));
	}

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		//addEmployees(employees, new CapitalistEmployeeFactory());
		addEmployees(employees, new SocialistEmployeeFactory());
		System.out.println(employees);
	}

}
