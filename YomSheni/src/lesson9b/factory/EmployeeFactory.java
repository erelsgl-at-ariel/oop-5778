package lesson9b.factory;

import lesson9.employees.Employee;
import lesson9.employees.Manager;
import lesson9.employees.Programmer;
import lesson9a.*;

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
