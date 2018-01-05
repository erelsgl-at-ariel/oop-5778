package template;

import java.util.List;

public class LinearSearchSimulator extends SearchSimulator {

	@Override public void sort(List<Integer> list) { }

	@Override public int find(List<Integer> haystack, int needle) {
		return haystack.indexOf(needle);
	}
}
