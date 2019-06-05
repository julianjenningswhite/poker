
public class TexasHoldem {
	public static void main (String[] args) {
		System.out.println("Testing Texas Holdem");
		
		Deck deck1 = new Deck();
		HoleCards holeCards1 = new HoleCards(deck1, 2);
		Board board1 = new Board(deck1);
		System.out.println(holeCards1);
		System.out.println(board1);
		System.out.println(deck1);
	}
}
