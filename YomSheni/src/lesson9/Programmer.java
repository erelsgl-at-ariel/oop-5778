package lesson9;

/**
 * A programmer is an employee that gets a reduction for writing too many lines.
 * 
 * @author erelsgl
 */
public class Programmer extends Employee {
    int linesWritten;

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
    public double getSalary() { 
        return super.getSalary() - this.linesWritten/10;
    }
}
