import java.util.ArrayList;

public class Board {
	final static int generalBoardSize = 5;
	ArrayList<Card> board = new ArrayList<Card>();
	
	public Board() {
		Deck deck = new Deck();
		
		for (int i = 0; i < generalBoardSize; i++) {
			this.board.add(deck.takeCard());
		}
	}
	
	public Board(int size) {
		Deck deck = new Deck();
		
		for (int i = 0; i < size; i++) {
			this.board.add(deck.takeCard());
		}
	}
	
	public Board(Deck deck) {
		for (int i = 0; i < generalBoardSize; i++) {
			this.board.add(deck.takeCard());
		}
	}
	
	public void add(Card card) {
		this.board.add(card);
	}
	
	public String toString() {
		String returnString = super.toString() + "\n";
		for (Card cardToPrint : board) {
			returnString += cardToPrint.toString() + "\n";
		}
		
		return returnString;
	}
}
