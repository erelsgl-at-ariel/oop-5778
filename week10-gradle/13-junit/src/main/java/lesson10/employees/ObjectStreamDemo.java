package lesson10.employees;

import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * Demonstrates serialization and de-serialization using ObjectInput/OutputStream 
 *
 * @author erelsgl
 */
public class ObjectStreamDemo {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		testEmployee();
//		testManager();
		testList();
	}

	private static void testEmployee() throws IOException, ClassNotFoundException {
		Employee e1 = new Employee("A",100);
		System.out.println(e1);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);

		oos.writeObject(e1);
		byte[] bytes = baos.toByteArray();
		System.out.println(Arrays.toString(bytes));
		
		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Employee e2 = (Employee) ois.readObject();
		System.out.println(e2);
		
        System.out.println(e1.toString().equals(e2.toString()));
        System.out.println();
    }

	private static void testManager() throws IOException, ClassNotFoundException {
		Manager m1 = new Manager("M",1000);
		m1.addToTeam(new Employee("A",100));
		m1.addToTeam(new Programmer("B",200));
		System.out.println(m1);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(m1);
		byte[] bytes = baos.toByteArray();
		System.out.println(Arrays.toString(bytes));

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Employee m2 = (Employee) ois.readObject();
		System.out.println(m2);        
        System.out.println(m1.toString().equals(m2.toString()));
        System.out.println();
	}
	

	private static void testList() throws IOException, ClassNotFoundException {
		List<Employee> employees = new ArrayList<>();
		Manager m1  = new Manager("M",1000);
		Employee e1 = new Employee("E",100);
		Programmer p1 = new Programmer("P",200);
		m1.addToTeam(e1);
		m1.addToTeam(p1);
		Collections.addAll(employees, m1, e1, p1);
		System.out.println(employees);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(employees);
		byte[] bytes = baos.toByteArray();
		System.out.println(Arrays.toString(bytes));

		ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
		ObjectInputStream ois = new ObjectInputStream(bais);
		List<Employee> employees2 = (List<Employee>) ois.readObject();
        System.out.println(employees2);        
        System.out.println(employees.toString().equals(employees2.toString()));

        // The two statements below show that Java's serialization mechacnism knows to cope with multiple objects. 
        // The same "Programmer" appears twice in employees:
        System.out.println(
            	employees.get(2)==
            	((Manager)employees.get(0)).getTeam().get(1));
        // As expected, it is not duplicated in employees2:
        System.out.println(
            	employees2.get(2)==
            	((Manager)employees2.get(0)).getTeam().get(1));
        System.out.println();
        System.out.println(m1 instanceof Serializable);
	}
}
