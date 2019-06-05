import java.util.ArrayList;

public class HoleCards {
	ArrayList<Card> holeCards = new ArrayList<Card>();
	
	public HoleCards(int handSize) {
		this(new Deck(), handSize);	
	}
	
	public HoleCards(Deck deck, int handSize) {
		for (int i = 0; i < handSize; i++ ) {
			holeCards.add(deck.takeCard());
			
		}
	}
	
	public HoleCards(int handSize, boolean isReal) {
		for (int i = 0; i < handSize; i++) {
			Card cardToAdd = new Card(Rank.of(3), Suit.CLUBS);
			holeCards.add(cardToAdd);
		}
	}
	
	public void add(Card card) {
		this.holeCards.add(card);
	}
	
	public String toString() {
		String returnString = super.toString() + "\n";
		
		for (Card cardToPrint : holeCards) {
			returnString += cardToPrint.toString() + "\n";
		}
		
		return returnString;
	}
}