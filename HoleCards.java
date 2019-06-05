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
		hand.add(new Card(Rank.of(3), Suit.CLUBS));
		hand.add(new Card(Rank.of(3), Suit.DIAMONDS));
		hand.add(new Card(Rank.of(3), Suit.HEARTS));
		hand.add(new Card(Rank.of(3), Suit.SPADES));
		hand.add(new Card(Rank.of(4), Suit.CLUBS));
	}
	
	public ArrayList<Rank> getRanks() {
		ArrayList<Rank> rankArray = new ArrayList<Rank>();
		for (int i = 0; i < hand.size(); i++)
			rankArray.add(hand.get(i).rank);
		return rankArray;
	}
	
	public ArrayList<Suit> getSuits() {
		ArrayList<Suit> suitArray = new ArrayList<Suit>();
		for (int i = 0; i < hand.size(); i++)
			suitArray.add(hand.get(i).suit);
		return suitArray;
	}
	
	public String toString() {
		String handString = "";
		
		for (Card cardToPrint : hand) {
			handString += cardToPrint.toString() + "\n";
		}
		
		return handString;
	}
}