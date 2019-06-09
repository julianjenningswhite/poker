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
	
	public ArrayList<Integer> getRanks() {
		ArrayList<Integer> rankArray = new ArrayList<Integer>();
		for (int i = 0; i < holeCards.size(); i++)
			rankArray.add(holeCards.get(i).rank.getValue());
		return rankArray;
	}
	
	public ArrayList<Suit> getSuits() {
		ArrayList<Suit> suitArray = new ArrayList<Suit>();
		for (int i = 0; i < holeCards.size(); i++)
			suitArray.add(holeCards.get(i).suit);
		return suitArray;
	}
	
	public Card getHighestCard() {
		this.holeCards.sort(Card.rankComparator);
		if (this.holeCards.get(0).rank.getValue() == 1)
			return this.holeCards.get(0);
		else
			return this.holeCards.get(this.holeCards.size() - 1);
	}
	
	public ArrayList<Card> getSameSuit(Suit suit) {
		ArrayList<Card> sameSuitArray = new ArrayList<Card>();
		for (Card card : this.holeCards) {
			if (card.suit.equals(suit))
				sameSuitArray.add(card);
		}
		return sameSuitArray;
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
