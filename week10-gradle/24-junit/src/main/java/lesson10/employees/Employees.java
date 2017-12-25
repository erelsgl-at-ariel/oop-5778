package lesson10.employees;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement  // for JAXB
public class Employees {
	private List<Employee> employees = new ArrayList<>();

	public Employees() { } // for JAXB	

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public String toString() {
		return employees.toString();
	}
}
