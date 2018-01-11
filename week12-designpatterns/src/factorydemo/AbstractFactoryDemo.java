package factorydemo;

import java.util.*;

import employees.*;

public class AbstractFactoryDemo {
	
	public static void testDepartment1(AbstractEmployeeFactory factory) {
		List<Employee> employees = new ArrayList<>();
		employees.add(factory.newEmployee("A", 5));
		employees.add(factory.newEmployee("B", 15));
		employees.add(factory.newEmployee("C", 25));
		//employees.add(new Programmer("SPY",100));
		System.out.println(employees);
	}
	
	public static void testDepartment2(AbstractEmployeeFactory factory) {
		List<Employee> employees = new ArrayList<>();
		employees.add(factory.newEmployee("D", 5));
		employees.add(factory.newEmployee("E", 15));
		employees.add(factory.newEmployee("F", 25));
		//employees.add(new Programmer("SPY",100));
		System.out.println(employees);
	}

	public static void main(String[] args) {
		testDepartment1(new CapitalistEmployeeFactory());
		testDepartment1(new SocialistEmployeeFactory());
		testDepartment1(new CommunistEmployeeFactory());
	}

}
