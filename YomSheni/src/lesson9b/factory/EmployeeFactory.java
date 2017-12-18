package lesson9b.factory;

import lesson9a.*;
import lesson9a.employees.Employee;
import lesson9a.employees.Manager;
import lesson9a.employees.Programmer;

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
