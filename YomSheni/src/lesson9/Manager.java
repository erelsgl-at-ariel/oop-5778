package lesson9;

/**
 * A manager is an employee that gets a bonus.
 * 
 * @author Cay S. Horstmann
 */
public class Manager extends Employee {
    double bonus;
    
    public Manager(String name, double salary) {
        super(name, salary);
        bonus = 0;
    }
    
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    @Override
    public double getSalary() { 
        return super.getSalary() + bonus;
    }
}
