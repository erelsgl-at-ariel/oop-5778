package employees;

/**
 * A manager in a communist factory.
 * 
 * Based on classes by Udi Lavi and Cay S. Horstmann
 */
public class PartyLeader extends PartyMember {
    double bonus;
    
    public PartyLeader(String name, double salary) {
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

    @Override
	public String toString() {
		return "PartyLeader [bonus=" + bonus + ", name=" + name + ", salary=" + salary + "]";
	}
}
