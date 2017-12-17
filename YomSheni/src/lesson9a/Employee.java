package lesson9a;

import java.time.LocalDate;

/**
 * Based on classes by Udi Lavi and Cay S. Horstmann.
 * 
 * @author erelsgl
 */
public class Employee extends Object {
    String name;
    double salary;
    LocalDate joinDate;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.joinDate = null;  // currently not implemented
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;    
    }
    
    public final String getName() {
        return name;
    }
    
    public double getSalary() {
        return salary;
    }
    
    @Override public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

	/**
     * Returns "true" if this employee has a lower rank than the 
     * other employee. This is calculated by the join date: 
     * workers that joined later have lower rank than workers that joined earlier. 
     */
    public boolean lowerRankThan(Employee other) {
    	return this.joinDate.isAfter(other.joinDate);  
    }
    
    public Employee getSupervisor() {
    	return null;   // NOT IMPLEMENTED YET  
    }

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((joinDate == null) ? 0 : joinDate.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		long temp;
//		temp = Double.doubleToLongBits(salary);
//		result = prime * result + (int) (temp ^ (temp >>> 32));
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		
		Employee other = (Employee) obj;
		
		if (joinDate == null) {
			if (other.joinDate != null)
				return false;
		} else if (!joinDate.equals(other.joinDate))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;

		return true;
	}
    
   
    
}
