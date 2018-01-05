package employees;

/**
 * A programmer is an employee that gets a reduction for writing too many lines.
 * 
 * @author erelsgl
 */
public class PartyProgrammer extends PartyMember {
	private int linesWritten = 0;
	
    public PartyProgrammer(String name, double salary) {
        super(name, salary);
    }

    public void addLines(int lines) {
        this.linesWritten += lines;
    }

    public void delLines(int lines) {
        this.linesWritten -= lines;
    }

    @Override
	public String toString() {
		return "PartyProgrammer [linesWritten=" + linesWritten + ", salary=" + salary + ", joinDate=" + joinDate + "]";
	}

	@Override
    public double getSalary() { 
        return super.getSalary() - this.linesWritten/10;
    }
   }
