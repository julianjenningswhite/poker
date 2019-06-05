import java.util.ArrayList;

public class HoleCards {
	ArrayList<Card> holeCards = new ArrayList<Card>();

	public HoleCards(int handSize) {
		for (int i = 0; i < handSize; i++) {
			holeCards.add(Deck.random());
		}
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

	public String toString() {
		String handString = "";

		for (Card cardToPrint : holeCards) {
			handString += cardToPrint.toString() + "\n";
		}

		return handString;
	}
}
