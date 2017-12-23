package lesson9a.employees;

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
		
//		Employee e1 = new Employee("B",200);
//		Employee e2 = e1;
//		Employee e3 = new Employee("B",200);
//		System.out.println(e1.equals(e2));
//		System.out.println(e1==e2);
//		System.out.println(e1.equals(e3));
//		System.out.println(e1==e3);
//		System.out.println(e1.getClass() == e3.getClass());
//		System.out.println(e1.getClass().equals(e3.getClass()));
//		//System.out.println(e1 instanceof Employee);
	}
	
	public static void main(String[] args) {
		test(new ArrayList<>());
		test(new HashSet<>());
		//test(new ConcurrentSkipListSet<>(Comparator.comparing(x->x.getName())));
		//test(new TreeSet<>(Comparator.comparing(x->x.getName())));
//		Object[] arrayOfObj = new Object[10];
//		arrayOfObj[0] = "abc";
//		arrayOfObj[1] = new Employee("5",6);
		
	}
}
