import java.util.ArrayList;

public class HoleCards {
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public HoleCards(int handSize) {
		for (int i = 0; i < handSize; i++) {
			Card cardToAdd = Deck.random();
			hand.add(cardToAdd);
		}
	}
	
	public HoleCards(int handSize, boolean isReal) {
		for (int i = 0; i < handSize; i++) {
			Card cardToAdd = new Card(Rank.of(3), Suit.CLUBS);
			hand.add(cardToAdd);
		}
	}
	
	public String toString() {
		String handString = "";
		
		for (Card cardToPrint : hand) {
			handString += cardToPrint.toString() + "\n";
		}
		
		return handString;
	}
}