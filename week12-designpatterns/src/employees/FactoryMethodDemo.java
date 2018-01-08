package employees;

import java.util.*;

public class FactoryMethodDemo {
	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(EmployeeFactory.newEmployee("A", 5));
		employees.add(EmployeeFactory.newEmployee("B", 15));
		employees.add(EmployeeFactory.newEmployee("C", 25));

		employees.add(EmployeeFactory.newSuperEmployee("C", 25));
		System.out.println(employees);
	}
}
