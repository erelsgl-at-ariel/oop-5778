package factory;

import java.util.*;

import employees.Employee;

public class EmployeeFactoryDemo {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(EmployeeFactory.newEmployee(EmployeeRank.SIMPLE, "A"));
		employees.add(EmployeeFactory.newEmployee(EmployeeRank.MANAGER, "B"));
		employees.add(EmployeeFactory.newEmployee(EmployeeRank.PROGRAMMER, "C"));
		System.out.println(employees);
	}

}
