package employees;

import java.io.Serializable;

import javax.xml.bind.annotation.*;

/**
 * Based on classes by Udi Lavi and Cay S. Horstmann.
 * @author erelsgl
 */
@XmlSeeAlso({Programmer.class,Manager.class})
@XmlRootElement // for JAXB
public class Employee implements Serializable {
    private  String name = "";
    private double salary = 0;
    
    // This is obligatory for JAXB!
    public Employee() {}

    public Employee(String name, double salary) {
        setName(name);
        this.salary = salary;
    }
    
    public void setName(String name) {
    	this.name = name.toUpperCase();
    }
    
    public final String getName() {
        return name;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }

    
    public void setSalary(double salary) {
    	this.salary = salary;
    }
    

    public double getSalary() {
        return salary;
    }
    
    @Override public String toString() {
		return "Employee [name=" + name + ", salary=" + getSalary() + "]";
	}
}
