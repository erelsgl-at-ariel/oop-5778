/**
 * 
 */
package lesson2;

import javafx.scene.chart.XYChart;

/**
 * Represents a function of one variable, y=f(x).
 * @author erelsgl
 */
public interface Function {
	double apply(double x);
	
	default void plot(double xFrom, double xTo, int numValues) {
		XYChart.Series series = new XYChart.Series();
		double xDelta= (xTo-xFrom)/(numValues-1);
		for (double x=xFrom; x<=xTo; x+=xDelta)
			series.getData().add(new XYChart.Data(x, this.apply(x)));
		Plotter.plot(series);
	}
}
