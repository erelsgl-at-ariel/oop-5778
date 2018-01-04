package employees;

import java.io.*;
import java.util.*;

import javax.xml.bind.*;

/**
 * Demonstrates serialization and de-serialization to/from XML using JAXB 
 *
 * @author erelsgl
 */
public class JaxbDemo {
	public static void main(String[] args) throws JAXBException {
//		testEmployee();
//		testManager();
		testList();
	}

	private static void testEmployee() throws JAXBException {
		Employee e1 = new Employee("A",100);
		System.out.println(e1);

        JAXBContext ctx = JAXBContext.newInstance(Employee.class);

        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        m.marshal(e1, sw);
        String e1string = sw.toString();
        System.out.println(e1string);
        
        Unmarshaller um = ctx.createUnmarshaller();
        Employee e2 = (Employee)um.unmarshal(new StringReader(e1string));
        System.out.println(e2);        
        System.out.println(e1.toString().equals(e2.toString()));
        System.out.println();
    }

	private static void testManager() throws JAXBException {
		Manager m1 = new Manager("M",1000);
		m1.addToTeam(new Employee("A",100));
		m1.addToTeam(new Programmer("B",200));
		System.out.println(m1);

        JAXBContext ctx = JAXBContext.newInstance(Manager.class);
        
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        m.marshal(m1, sw);
        String m1string = sw.toString();
        System.out.println(m1string);
        
        Unmarshaller um = ctx.createUnmarshaller();
        Employee m2 = (Employee)um.unmarshal(new StringReader(m1string));
        System.out.println(m2);        
        System.out.println(m1.toString().equals(m2.toString()));
        System.out.println();
	}
	

	private static void testList() throws JAXBException {
		List<Employee> employees = new ArrayList<>();
		Manager m1  = new Manager("M",1000);
		Employee e1 = new Employee("E",100);
		Programmer p1 = new Programmer("P",200);
		m1.addToTeam(e1);
		m1.addToTeam(p1);
		Collections.addAll(employees, m1, e1, p1);
		System.out.println(employees);

        JAXBContext ctx = JAXBContext.newInstance(Employees.class);
        
        Marshaller m = ctx.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        //m.marshal(employees, sw); // this causes a runtime exception since ArrayList does not have @XmlRootElement!
        Employees employees1 = new Employees();
        employees1.setEmployees(employees);
        m.marshal(employees1, sw);
        String employeesstring = sw.toString();
        System.out.println(employeesstring);
        
        Unmarshaller um = ctx.createUnmarshaller();
        Employees employees2 = (Employees)um.unmarshal(new StringReader(employeesstring));
        System.out.println(employees2);        
        System.out.println(employees1.toString().equals(employees2.toString()));

        // The two statements below show a problem with JAXB.
        // The same "Programmer" appears twice in employees1:
        System.out.println(
            	employees1.getEmployees().get(2)==
            	((Manager)employees1.getEmployees().get(0)).getTeam().get(1));
        // ... but in employees2, it is duplicated:
        System.out.println(
            	employees2.getEmployees().get(2)==
            	((Manager)employees2.getEmployees().get(0)).getTeam().get(1));
        System.out.println();
	}
}
