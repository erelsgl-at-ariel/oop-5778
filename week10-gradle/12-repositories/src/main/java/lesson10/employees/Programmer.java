package lesson10.employees;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * A programmer is an employee that gets a reduction for writing too many lines.
 * 
 * @author erelsgl
 */
@XmlRootElement
public class Programmer extends Employee {
    int linesWritten;

    public Programmer() {   // obligatory for JAXB
    	super();
    }
    
    public Programmer(String name, double salary) {
        super(name, salary);
        linesWritten = 0;
    }

    public void addLines(int lines) {
        this.linesWritten += lines;
    }

    public void delLines(int lines) {
        this.linesWritten -= lines;
    }

    @Override
	public String toString() {
		return "Programmer [name="+getName() + ", linesWritten=" + linesWritten + ", salary=" + getSalary() + "]";
	}

	@Override
    public double getSalary() { 
        return super.getSalary() - this.linesWritten/10;
    }
}
