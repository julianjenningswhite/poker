import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings({ "unused" })
public class Deck {
	static ArrayList<Card> deck = new ArrayList<Card>();
	private ArrayList<Rank> rankArray = new ArrayList<Rank>();
	private ArrayList<Suit> suitArray = new ArrayList<Suit>();
	public Deck() {
		for (int i = 0; i < 13; i++) {
			for (int j = 0; j < 4; j++) {
				deck.add(new Card(Rank.values()[i], Suit.values()[j]));
			}
		}
	}
	
	public static Card random() {
		Random generator = new Random();
		int index = generator.nextInt(deck.size());
        Card cardToReturn = deck.get(index);
        deck.remove(index);
	    return cardToReturn;
	}
}


/*
while (deck.size() < 52) {
Card cardToAssign = Card.random();
if (Collections.frequency(rankArray, cardToAssign.rank) == 0 || Collections.frequency(suitArray, cardToAssign.suit) == 0) {
	deck.add(cardToAssign);
	rankArray.add(cardToAssign.rank);
	suitArray.add(cardToAssign.suit);
}
}
*/
