package employees;

/**
 * A factory class for creating Employee objects by level.
 * @author erelsgl
 */
public class CapitalistEmployeeFactory implements AbstractEmployeeFactory {
	public Employee newEmployee(String name, int level) {
		if (0<=level && level<=9)
			return new Employee(name, level*1000);
		else if (10<=level && level<=19) {
			Manager m = new Manager(name, level*1000);
			m.setBonus(500);
			return m;
		} else if (20<=level && level<=29)
			return new Programmer(name, (level-10)*1000 - 500);
		else 
			throw new IllegalArgumentException("level="+level);
	}
}
