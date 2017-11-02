package lesson2;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 * A static method for creating 2-dimensional plots of series.
 * 
 * Based on https://docs.oracle.com/javafx/2/charts/line-chart.htm
 *      and https://stackoverflow.com/a/29878704/827927
 *      
 * @author erelsgl
 * 
 * @note To make it work in Eclipse, I had to install Java 9 and install Eclipse Oxygen.
 */
public class Plotter {
	public static void plot(XYChart.Series... series) {
		LineChart<Number,Number> lineChart = new LineChart<Number,Number>(new NumberAxis(), new NumberAxis());
		for (XYChart.Series s: series)
			lineChart.getData().add(s);
		Scene scene  = new Scene(lineChart,800,600);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}
}
