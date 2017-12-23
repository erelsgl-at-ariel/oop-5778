package lesson9.stacks;

public class WifiSampleTest {

	public static void main(String[] args) {
		WifiSample0 sample = new WifiSample0();
		sample.add("12"); //lat
		sample.add("34"); //lon
		sample.add("150"); //alt
		sample.add("12:00:00");
		System.out.println(sample.getTime());
		
		sample.add(0, "56");
		System.out.println(sample.getTime());

		WifiSample1 sample1 = new WifiSample1();
	}

}
