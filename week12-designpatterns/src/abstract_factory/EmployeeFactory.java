package abstract_factory;

import employees.Employee;

public interface EmployeeFactory {
	Employee newEmployee(EmployeeRank rank, String name);
}
