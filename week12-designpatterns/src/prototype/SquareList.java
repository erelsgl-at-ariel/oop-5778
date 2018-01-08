package prototype;

import java.util.*;

public class SquareList implements Shape {
	private List<Square> squares = new ArrayList<>();

	public SquareList(List<Square> squares) {
		this.squares = squares;
	}
	
	public List<Square> getSquares() {
		return squares;
	}
	
	@Override
	public void plot() {
		for (Square s: squares)
			s.plot();
	}
	
	public void addSquare(Square s) {
		this.squares.add(s);
	}

	@Override
	public Shape clone() {
		List<Square> newSquares = new ArrayList<>();
		for (Square s: this.squares)
			newSquares.add((Square)s.clone());
		return new SquareList(newSquares);
	}

	@Override
	public void setSize(int size) {
		
	}

}
 