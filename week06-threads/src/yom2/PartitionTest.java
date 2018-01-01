package yom2;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.*;

/**
 * A JUnit test for Partition.
 * 
 * @author erelsgl
 */
public class PartitionTest {
	
	@Test public void testSubsetByBinaryRepresentation() {
		List<Double> values = Arrays.asList(1.2, 3.4);
		assertThat(Partition.subsetByBinaryRepresentation(values, 0), is(Arrays.asList()));
		assertThat(Partition.subsetByBinaryRepresentation(values, 1), is(Arrays.asList(1.2)));
		assertThat(Partition.subsetByBinaryRepresentation(values, 2), is(Arrays.asList(3.4)));
		assertThat(Partition.subsetByBinaryRepresentation(values, 3), is(Arrays.asList(1.2,3.4)));
	}
	
	private void sortOutput(List<Double>[] output) {
		output[0].sort( (x,y) -> Double.compare(x,y) );
		output[1].sort( (x,y) -> Double.compare(x,y) );
		Arrays.sort(output,  (x,y)->x.toString().compareTo(y.toString()) );
	}
	

	@Test public void test12() {
		List<Double> values = Arrays.asList(1.0, 2.0);
		List<Double>[] output = Partition.best(values);
//		double sum0 = // sum of output[0]
//		double sum1 = // sum of output[1]
//		double diff = Math.abs(sum0-sum1);
//		assertThat(diff, is(1.0));
		sortOutput(output);
		assertThat(output[0], is(Arrays.asList(1.0)));
		assertThat(output[1], is(Arrays.asList(2.0)));
	}

	@Test public void test1234() {
		List<Double> values = Arrays.asList(1.0, 4.0, 3.0, 2.0);
		List<Double>[] output = Partition.best(values);
		sortOutput(output);
		assertThat(output[0], is(Arrays.asList(1.0, 4.0)));
		assertThat(output[1], is(Arrays.asList(2.0, 3.0)));
	}

	@Test public void test1() {
		List<Double> values = Arrays.asList(1.0);
		List<Double>[] output = Partition.best(values);
		sortOutput(output);
		assertThat(output[0], is(Arrays.asList(1.0)));
		assertThat(output[1], is(Arrays.asList()));
	}
	
	@Test(expected = IllegalArgumentException.class) 
	public void testTooLarge() {
		Double[] array = new Double[100];
		Arrays.fill(array, 1.0);		
		List<Double> values = Arrays.asList(array);
		Partition.best(values);
	}
	

}
