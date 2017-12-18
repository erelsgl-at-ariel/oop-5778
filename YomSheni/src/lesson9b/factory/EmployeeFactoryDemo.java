package lesson9b.factory;

import java.util.*;

import lesson9a.employees.Employee;

public class EmployeeFactoryDemo {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(EmployeeFactory.newEmployee(EmployeeRank.SIMPLE, "A"));
		employees.add(EmployeeFactory.newEmployee(EmployeeRank.MANAGER, "B"));
		employees.add(EmployeeFactory.newEmployee(EmployeeRank.PROGRAMMER, "C"));
		System.out.println(employees);
	}

}
