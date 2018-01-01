package abstract_factory;

public enum EmployeeRank {
	SIMPLE(10_000), MANAGER(30_000), PROGRAMMER(50_000);
	
	EmployeeRank(double initialSalary) {
		this.INITIAL_SALARY = initialSalary;
	}
	
	final double INITIAL_SALARY;
}
