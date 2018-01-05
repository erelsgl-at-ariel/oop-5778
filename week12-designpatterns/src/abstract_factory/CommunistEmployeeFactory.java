package abstract_factory;

import employees.*;

/**
 * A factory class for creating Employee objects by level.
 * @author erelsgl
 */
public class CommunistEmployeeFactory implements EmployeeFactory {
	public Employee newEmployee(String name, int level) {
		if (0<=level && level<=9)
			return new PartyMember(name, 0);
		else if (10<=level && level<=19)
			return new PartyLeader(name, 0);
		else if (20<=level && level<=29)
			return new PartyProgrammer(name, 0);
		else 
			throw new IllegalArgumentException("level="+level);
	}
}
