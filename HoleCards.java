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

	public HoleCards(Deck deck, int handSize, boolean isReal) {
		holeCards.add(new Card(Rank.of(6), Suit.CLUBS));
		holeCards.add(new Card(Rank.of(6), Suit.DIAMONDS));
		holeCards.add(new Card(Rank.of(6), Suit.HEARTS));
		holeCards.add(new Card(Rank.of(6), Suit.SPADES));
		holeCards.add(new Card(Rank.of(3), Suit.CLUBS));

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
