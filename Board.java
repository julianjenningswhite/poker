public class Board {
	Card[] board = new Card[5];
	
	public Board() {
		for (int i = 0; i < 5; i++) {
			this.board[i] = Deck.random();
		}
	}
}
