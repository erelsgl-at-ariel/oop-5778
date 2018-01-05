package abstract_factory;

import employees.*;

/**
 * A factory class for creating Employee objects by level.
 * @author erelsgl
 */
public class SocialistEmployeeFactory implements EmployeeFactory {
	private final static double SOCIAL_INITIAL_SALARY = 10000;
	public Employee newEmployee(String name, int level) {
		if (0<=level && level<=9)
			return new Employee(name, SOCIAL_INITIAL_SALARY);
		else if (10<=level && level<=19) {
			Manager m = new Manager(name, SOCIAL_INITIAL_SALARY);
			m.setBonus(500);
			return m;
		} else if (20<=level && level<=29)
			return new Programmer(name, SOCIAL_INITIAL_SALARY);
		else 
			throw new IllegalArgumentException("level="+level);
	}
}
