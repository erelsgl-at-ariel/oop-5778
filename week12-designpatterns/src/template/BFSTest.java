package template;

public class BFSTest {

	public static void main(String[] args) {
		BFS bfs = new BFS() {
			@Override
			Object initial() {
				return null;
			}

			@Override
			Iterable neighbors(Object current) {
				return null;
			}

			@Override
			boolean isFinal(Object current) {
				return false;
			}
		};
	}

}
