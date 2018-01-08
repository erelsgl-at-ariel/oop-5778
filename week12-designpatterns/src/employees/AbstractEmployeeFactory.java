package employees;

public interface AbstractEmployeeFactory {
	Employee newEmployee(String name, int level);
}
