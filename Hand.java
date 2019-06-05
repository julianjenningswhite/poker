import java.util.ArrayList;
import java.util.Collections;

public class Hand {
	Card[] hand;
	int handSize;
	static ArrayList<Rank> handRankArray = new ArrayList<Rank>();
	static ArrayList<Suit> handSuitArray = new ArrayList<Suit>();
	public Hand() {
		hand = new Card[handSize];
		for (int i = 0; i < handSize; i++) {
			this.hand[i] = Deck.random();
			handRankArray.add(hand[i].rank);
			handSuitArray.add(hand[i].suit);
		}
	}
	
	
	
	
	
	
}