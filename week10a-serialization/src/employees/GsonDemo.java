package employees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

/**
 * Demonstrates serialization and de-serialization to/from JSON using GSON 
 *
 * @author erelsgl
 */
public class GsonDemo {
	public static void main(String[] args) {
		testEmployee();
//		testManager();
//		testList();
	}

	private static Gson gson = new Gson();

	private static void testEmployee() {
		Employee e1 = new Employee("A",100);
		System.out.println(e1);

		String e1string = gson.toJson(e1);
		System.out.println(e1string);
		Employee e2 = gson.fromJson(e1string, Employee.class);
		System.out.println(e2);
		System.out.println();
	}

	private static void testManager() {
		Manager e1 = new Manager("M",1000);
		e1.addToTeam(new Employee("A",100));
		e1.addToTeam(new Programmer("B",200));
		System.out.println(e1);

		String e1string = gson.toJson(e1);
		System.out.println(e1string);
		Manager e2 = gson.fromJson(e1string, Manager.class);
		System.out.println(e2);
		System.out.println();
	}
	

	private static void testList() {
		List<Employee> employees = new ArrayList<>();
		Manager m1  = new Manager("M",1000);
		Employee e1 = new Employee("E",100);
		Programmer p1 = new Programmer("P",200);
		m1.addToTeam(e1);
		m1.addToTeam(p1);
		Collections.addAll(employees, m1, e1, p1);
		System.out.println(employees);
		
		String employeesstring = gson.toJson(employees);
        System.out.println(employeesstring);
        
        List<Employee> employees2 = gson.fromJson(employeesstring, List.class);
        System.out.println(employees2.get(0).getClass());  // Runtime exception - the elements in the list are NOT Employee-s!
        System.out.println(employees2);
        System.out.println(employees.toString().equals(employees2.toString()));
        
        // The two statements below show a problem with JAXB.
        // The same "Programmer" appears twice in employees1:
//        System.out.println(
//            	employees1.getEmployees().get(2)==
//            	((Manager)employees1.getEmployees().get(0)).getTeam().get(1));
//        // ... but in employees2, it is duplicated:
//        System.out.println(
//            	employees2.getEmployees().get(2)==
//            	((Manager)employees2.getEmployees().get(0)).getTeam().get(1));
        System.out.println();
	}
	
}
