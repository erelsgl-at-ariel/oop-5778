package lesson9a;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Demonstrates how method overriding works with the Employee hierarchy.
 * @author erelsgl
 */
public class EmployeeDemoEquals {
	private static void test(Collection<Employee> employees) {
		System.out.println("A test with "+employees.getClass().getSimpleName());
		employees.add(new Employee("A", 100));
		employees.add(new Programmer("A", 100));
		employees.add(new Manager("A", 100));
		employees.add(new Employee("A", 100));
		System.out.println("We have "+employees.size()+" employees: "+employees);
		System.out.println(employees.contains(new Employee("A", 100)));
		System.out.println();
	}
	
	public static void main(String[] args) {
		test(new ArrayList<>());
		test(new HashSet<>());
		//test(new ConcurrentSkipListSet<>(Comparator.comparing(x->x.getName())));
		//test(new TreeSet<>(Comparator.comparing(x->x.getName())));
	}
}
