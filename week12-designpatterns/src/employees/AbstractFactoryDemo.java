package employees;

import java.util.*;

public class AbstractFactoryDemo {
	
	public static void addEmployees(List<Employee> employees, AbstractEmployeeFactory factory) {
		employees.add(factory.newEmployee("A", 5));
		employees.add(factory.newEmployee("B", 15));
		employees.add(factory.newEmployee("C", 25));
		
		//employees.add(new Programmer("SPY",100));
		System.out.println(employees);
	}

	public static void main(String[] args) {
		List<Employee> employees;

		employees = new ArrayList<>();
		addEmployees(employees, new CapitalistEmployeeFactory());
		System.out.println(employees);
	}

}
