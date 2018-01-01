package yom2;

public class AndCondition<T> implements Condition<T> {
	
	public AndCondition(Condition<T> c1, Condition<T> c2) {
		condition1 = c1;
		condition2 = c2;
	}
	
	@Override
	public boolean test(T s) {
		return condition1.test(s) && condition2.test(s);
	}

	private Condition<T> condition1, condition2;
}
