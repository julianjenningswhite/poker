// import java.util.Random;

public class Card {
	final Rank rank;
	final Suit suit;

	public Card(Rank rank, Suit suit) {
	    this.rank = rank;
	    this.suit = suit;
	}
}

/*
public static Card random() {
Random generator = new Random();
Rank rank = Rank.values()[generator.nextInt(Rank.values().length)];
Suit suit = Suit.values()[generator.nextInt(Suit.values().length)];
return new Card(rank, suit);
}
*/