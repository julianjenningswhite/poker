import java.util.ArrayList;

public class Board {
	Card[] board = new Card[5];
	ArrayList<Rank> boardRankArray = new ArrayList<Rank>();
	ArrayList<Suit> boardSuitArray = new ArrayList<Suit>();
	public Board() {
		for (int i = 0; i < 5; i++) {
			this.board[i] = Deck.random();
			boardRankArray.add(board[i].rank);
			boardSuitArray.add(board[i].suit);
		}
	}
}
