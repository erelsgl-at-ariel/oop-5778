package abstract_factory;

import employees.*;

/**
 * A factory class for creating Employee objects by rank.
 * @author erelsgl
 */
public class CapitalistEmployeeFactory implements EmployeeFactory {
	public Employee newEmployee(EmployeeRank rank, String name) {
		switch(rank) {
		case SIMPLE:  return new Employee(name, rank.INITIAL_SALARY);
		case MANAGER: return new Manager(name, rank.INITIAL_SALARY);
		case PROGRAMMER: return new Programmer(name, rank.INITIAL_SALARY);
		default: throw new IllegalArgumentException("rank="+rank);
		}
	}
}
