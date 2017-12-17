package lesson9a;

/**
 * A manager is an employee that gets a bonus.
 * 
 * Based on classes by Udi Lavi and Cay S. Horstmann
 */
public class Manager extends Employee {
    double bonus;
    
    // public Manager() {} compilation error
    
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
    
    
//  /* This is a compilation error! */
//    @Override public boolean lowerRankThan(Manager other) {
//    	return this.bonus < otherManager.bonus;
//    }

	@Override public boolean lowerRankThan(Employee other) {
		if (other instanceof Manager) {
			// ranks between managers are calculated based on their bonus:
			Manager otherManager = (Manager)other; // casting
			return this.bonus < otherManager.bonus;
		} else {
			// a manager is never lower than a non-manager:
			return false;
		}
	}

	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(bonus);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (!super.equals(obj)) return false;
		if (getClass() != obj.getClass()) return false;
		
		Manager other = (Manager) obj;
		if (Double.doubleToLongBits(bonus) != Double.doubleToLongBits(other.bonus))
			return false;
		return true;
	}
	
    
}
