package employees;

import java.time.LocalDate;

/**
 * An employee in a communist factory.
 * 
 * @author erelsgl
 */
public class PartyMember extends Employee {

    public PartyMember(String name, double salary) {
        super(name,salary);
    }    
    
    @Override public String toString() {
		return "PartyMember [name=" + name + ", salary=" + getSalary() + "]";
	}
}
