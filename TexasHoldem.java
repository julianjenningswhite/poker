public class TexasHoldem {
	public static void main (String[] args) {
		System.out.println("Testing Texas Holdem");
		
		System.out.println("Test 1");
		Deck deck1 = new Deck();
		HoleCards holeCards1 = new HoleCards(deck1, 2);
		Board board1 = new Board(deck1);
		System.out.println(holeCards1);
		System.out.println(board1);
		System.out.println(deck1);
		
		System.out.println("Test 2");
		HoleCards holeCards2 = new HoleCards(0);
		holeCards2.add(new Card(Rank.EIGHT, Suit.SPADES));
		holeCards2.add(new Card(Rank.EIGHT, Suit.CLUBS));
		Board board2 = new Board(0);
		board2.add(new Card(Rank.EIGHT, Suit.CLUBS));
		board2.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
		board2.add(new Card(Rank.SEVEN, Suit.DIAMONDS));
		board2.add(new Card(Rank.FIVE, Suit.CLUBS));
		board2.add(new Card(Rank.ACE, Suit.CLUBS));
		System.out.println(holeCards2);
		System.out.println(board2);
		
		System.out.println(HandRanking.rank(holeCards2, board2, GameType.TEXAS_HOLDELM));
	}
}
