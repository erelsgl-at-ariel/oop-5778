package lesson10.employees;

import java.util.*;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A manager is an employee that gets a bonus.
 * 
 * @author erelsgl
 */
@XmlRootElement // for JAXB
public class Manager extends Employee {
    double bonus;
	List<Employee> team;
    
    public Manager() { // Obligatory for JAXB 
    	super();
        bonus = 0;
        team = new ArrayList<>();
    }
    
    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
        team = new ArrayList<>();
    }

    public List<Employee> getTeam() {
		return team;
	}

	public void setTeam(List<Employee> team) {
		this.team = team;
	}

	public double getBonus() {
		return bonus;
	}
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public void addToTeam(Employee e) {
    	team.add(e);
    }
    
    /**
      * The salary of a manager is its base plus the bonus.
      @return the salary including the bonus.
     */
    @Override
    public double getSalary() { 
        return super.getSalary() + bonus;
    }


	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", name=" + getName() + ", salary=" + getSalary() + ",\n\tteam="+team+"]";
	}
}
