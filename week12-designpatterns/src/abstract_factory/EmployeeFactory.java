package abstract_factory;

import employees.Employee;

public interface EmployeeFactory {
	Employee newEmployee(String name, int level);
}
