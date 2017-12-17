package lesson9;

import java.util.List;

/**
 * Utility functions for handling lists of employees.
 * 
 * Works correctly with various kinds of employees
 * 
 * @author erelsgl
 */
public class Employees {
	public static double totalSalary(List<Employee> employees) {
		return employees.stream()
				.mapToDouble(e -> e.getSalary())
				.reduce( (x,y) -> x+y )
				.getAsDouble();
	}
}
