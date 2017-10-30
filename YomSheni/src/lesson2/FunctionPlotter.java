package lesson2;

import java.util.*;

import javafx.scene.chart.XYChart;

public class FunctionPlotter {
	
	static void plot(Function f, double xFrom, double xTo, int numPoints) {
		XYChart.Series series = new XYChart.Series();
		double difference = (xTo-xFrom)/numPoints;
		for (double x = xFrom; x<=xTo; x+=difference) {
			double y = f.apply(x);
			series.getData().add(new XYChart.Data(x,y));
		}
		Plotter.plot(series);
	}
	
	public static void run() {
		System.out.println("Hello plotter");
		
		// Solution A: use a named class
		Sine s = new Sine();
		//plot(s, 0, 10, 1000); // should plot y=sin(x) between 0 and 10
		s.plot(0, 10, 1000);
		
		// Solution B: use an anonymous class
		Function f = new Function() {
			public double apply(double x) {
				return x*Math.log(x);
			}
		};
		plot(f, 1, 10, 100); // should plot y=sin(x) between 0 and 10
	
		// Solution C: use one-line class
		Function f1 =  (x) -> 1/Math.tan(x);
		plot(f1, 1, 10, 100);
		
		plot( (x) -> Math.pow(x,3)+2*x, 0,10,100);
		
	}
}
