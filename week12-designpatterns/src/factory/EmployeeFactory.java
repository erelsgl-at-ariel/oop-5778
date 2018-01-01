package factory;

import employees.*;

/**
 * A factory class for creating Employee objects by rank.
 * @author erelsgl
 */
public class EmployeeFactory {
	public static Employee newEmployee(EmployeeRank rank, String name) {
		double initialSalary = rank.initialSalary;
		switch(rank) {
		case SIMPLE:  return new Employee(name, initialSalary);
		case MANAGER: return new Manager(name, initialSalary);
		case PROGRAMMER: return new Programmer(name, initialSalary);
		default: throw new IllegalArgumentException("rank="+rank);
		}
	}
}
