package exercises;

/**
 * NOTE: There is code duplication in the "isApproved" method.
 * 
 * EXERCISE: Refactor the class hierarchy using the Template pattern.
 *
 * @author erelsgl
 */
public class Loan {
	int duration;
}

class LoanForPrivatePerson extends Loan {
	int age, salary;
	boolean hasHouse;
	
	public boolean isApproved() {
		double riskFactor = age/salary;
		double safetyFactor = (hasHouse? 10: 5);
		return safetyFactor / riskFactor > duration;
	}
}

class LoanForBusinessextends extends Loan {
	int age, profits;
	int numOfMachines;
	
	public boolean isApproved() {
		double riskFactor = age/Math.sqrt(profits);
		double safetyFactor = numOfMachines+5;
		return safetyFactor / riskFactor > duration;
	}
}