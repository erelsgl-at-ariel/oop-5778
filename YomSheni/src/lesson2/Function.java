package lesson2;

import javafx.scene.chart.XYChart;

/**
 * Represents a function y=f(x)
 * @author erelsgl
 *
 */
public interface Function {
	/**
	 * Calculates the function on x.
	 * @param x
	 * @return y = f(x)
	 */
	double apply(double x);

	default void plot(double xFrom, double xTo, int numPoints) {
		XYChart.Series series = new XYChart.Series();
		double difference = (xTo-xFrom)/numPoints;
		for (double x = xFrom; x<=xTo; x+=difference) {
			double y = this.apply(x);
			series.getData().add(new XYChart.Data(x,y));
		}
		Plotter.plot(series);
	}
}
