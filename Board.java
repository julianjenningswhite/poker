public class Board {
	final static int boardSize = 5;
	Card[] board = new Card[boardSize];
	
	public Board() {
		for (int i = 0; i < boardSize; i++) {
			this.board[i] = Deck.random();
		}
	}
	
	public Board(Deck deck) {
		for (int i = 0; i < boardSize; i++) {
			this.board[i] = deck.takeCard();
		}
	}
	
	public String toString() {
		String returnString = "";
		for (Card cardToPrint : board) {
			returnString += cardToPrint.toString() + "\n";
		}
		
		return returnString;
	}
}
