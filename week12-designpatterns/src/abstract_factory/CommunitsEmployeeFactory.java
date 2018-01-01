package abstract_factory;

import employees.*;

/**
 * A factory class for creating Employee objects by rank.
 * @author erelsgl
 */
public class CommunitsEmployeeFactory implements EmployeeFactory {
	public Employee newEmployee(EmployeeRank rank, String name) {
		switch(rank) {
		case SIMPLE:  return new Employee(name, 0);
		case MANAGER: return new Manager(name, 0);
		case PROGRAMMER: return new Programmer(name, 0);
		default: throw new IllegalArgumentException("rank="+rank);
		}
	}
}
