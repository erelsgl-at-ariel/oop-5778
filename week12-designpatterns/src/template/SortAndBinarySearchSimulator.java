package template;

import java.util.Collections;
import java.util.List;

public class SortAndBinarySearchSimulator extends SearchSimulator {

	@Override public void sort(List<Integer> list) {
		Collections.sort(list);
	}

	@Override public int find(List<Integer> haystack, int needle) {
		return Collections.binarySearch(haystack, needle);
	}

}
