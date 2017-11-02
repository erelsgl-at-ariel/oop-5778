package lesson2;

import javafx.application.Application;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 

/**
 * A sample code for 2-D plots using JavaFX.
 * 
 * Adapted from: https://docs.oracle.com/javafx/2/charts/line-chart.htm
 * 
 * NOTE: To make it work in Eclipse, I had to install Java 9 and install Eclipse Oxygen.
 * 
 * @author erelsgl
 */
public class TestPlot extends Application {
	
	public static XYChart.Series getSeries(Function f, double xFrom, double xTo, int numValues) {
		XYChart.Series series = new XYChart.Series();
		double xDelta= (xTo-xFrom)/(numValues-1);
		for (double x=xFrom; x<=xTo; x+=xDelta)
			series.getData().add(new XYChart.Data(x, f.apply(x)));
		return series;
	}

	public static void plot(Function f, double xFrom, double xTo, int numValues) {
		Plotter.plot(getSeries(f,xFrom,xTo,numValues));
	}
	
	public static void plotWithDerivative(DifferentiableFunction f, double xFrom, double xTo, int numValues) {
		Plotter.plot(
				getSeries(f,xFrom,xTo,numValues),
				getSeries(f.getDerivative(),xFrom,xTo,numValues)
				);
	}
	
	@Override public void start(Stage dummy) {
			// A: using a named class
			Sine s = new Sine();
			plot(s, 0, 10, 100);
			
			// B: using an anonymous class
			// Function f1 = new Function(); // this does not work
			Function f1 = new Function() {
			@Override public double apply(double x) {
				return Math.cos(x);
			}
			};
			plot(f1, 0, 10, 100);
			
			// C: using a one-line function ("lambda expression")
			Function f2 = x->Math.tan(x);
			plot(f2, 0, 10, 100);
			
			// D: using a "method reference"
			plot(Math::exp, 0, 10, 100);
	
			// E: making an existing class implement the interface
			plot(new Monom(0.1, 2), 0, 10, 100);  // plot of x^2/10
			
			// F: using a "default function" of the interface
			Monom m1 = new Monom(0.1, 10);
			m1.plot(0, 10, 100);
		
		// G: Using an extending interface:
		DifferentiableFunction f3 = new DifferentiableFunction() {
			@Override public double apply(double x) {
				return Math.sin(x);
			}
			@Override public Function getDerivative() {
				return x->Math.cos(x);
			}
		};
		plotWithDerivative(f3, 0, 10, 100);  // plots of sin(x),cos(x)
		
		// H: the Runnable interface
		Runnable r = ()->System.out.print("x"); 
		repeat(10, r);
	}
	
	private void repeat(int n, Runnable r) {
		for (int i=0; i<n; ++i)
			r.run();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
