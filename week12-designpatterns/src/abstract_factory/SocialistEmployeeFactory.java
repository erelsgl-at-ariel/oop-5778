package abstract_factory;

import employees.*;

/**
 * A factory class for creating Employee objects by rank.
 * @author erelsgl
 */
public class SocialistEmployeeFactory implements EmployeeFactory {
	private final static double SOCIAL_INITIAL_SALARY = 10000;
	public Employee newEmployee(EmployeeRank rank, String name) {
		switch(rank) {
		case SIMPLE:  return new Employee(name, SOCIAL_INITIAL_SALARY);
		case MANAGER: return new Manager(name, SOCIAL_INITIAL_SALARY);
		case PROGRAMMER: return new Programmer(name, SOCIAL_INITIAL_SALARY);
		default: throw new IllegalArgumentException("rank="+rank);
		}
	}
}
