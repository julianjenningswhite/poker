import java.util.ArrayList;
import java.util.Collections;

public class BigO {
	// iterates through all hand combinations
	public static double bestHand(Hand hand, Board board) {
		double ranking = 0;
		for (int i = 0; i < hand.hand.size(); i++) {
			for (int j = i + 1; j < hand.hand.size(); j++) {
				Hand playHand = new Hand(2);
				playHand.add(hand.hand.get(i));
				playHand.add(hand.hand.get(j)); 
				if (ranking > evaluate(playHand, board))
					ranking = evaluate(playHand, board); // computes numerical value elsewhere, here just get the highest numerical value
			}
		}
		return ranking;
	}
	
	// evaluates one hand combination with the board
	public static double evaluate(Hand hand, Board board) {
		double ranking = 0;
		if (straightFlush(hand, board) != 0) {
			ranking = straightFlush(hand, board);
		} else if (quads(hand, board) != 0) {
			ranking = quads(hand, board);
		} else if (fullHouse(hand, board) != 0) {
			ranking = fullHouse(hand, board);
		} else if (flush(hand, board) != 0) {
			ranking = flush(hand, board);
		} else if (staight(hand, board) != 0) {
			ranking = staight(hand, board);
		} else if (threeOfAKind(hand, board) != 0) {
			ranking = threeOfAKind(hand, board);
		} else if (twoPair(hand, board) != 0) {
			ranking = twoPair(hand, board);
		} else if (pair(hand, board) != 0) {
			ranking = pair(hand, board);
		} else if (highCard(hand, board) != 0) {
			ranking = highCard(hand, board);
		}
		return ranking;
	}
	
	public static double straightFlush(Hand hand, Board board) {
		double straightFlush = 0;
		
		return straightFlush;
	}
	
	public static double quads(Hand hand, Board board) {
		double quads = 0;
		
		return quads;
	}
	
	public static double fullHouse(Hand hand, Board board) {
		double fullHouse = 0;
		
		return fullHouse;
	}
	
	static Suit flushSuit;
	static ArrayList<Card> flushCards;
	
	public static double flush(Hand hand, Board board) {
		double flush = 0;
		for (Suit suit : Suit.values()) {
			if (hand.getSameSuit(suit).size() >= 2 && board.getSameSuit(suit).size() >= 3) {
				
				flushSuit = suit;
				flushCards.addAll(hand.getSameSuit(suit).sort(rankComparator));
				flushCards.addAll(board.getSameSuit(suit));
				flushCards.sort(Card.rankComparator);
				double power = 1;
				for (int i = flushCards.size()-1; i > flushCards.size()-6; i--) {
					flush = 6 + (flushCards.get(i).rank.getStrength()) * Math.pow(10, power);
					power = power - 2;
				}
			}
		}
		return flush;
	}
	
	public static double staight(Hand hand, Board board) {
		double staight = 0;
		
		return staight;
	}
	
	public static double threeOfAKind(Hand hand, Board board) {
		double threeOfAKind = 0;
		
		return threeOfAKind;
	}
	
	public static double twoPair(Hand hand, Board board) {
		double twoPair = 0;
		
		return twoPair;
	}
	
	public static double pair(Hand hand, Board board) {
		double pair = 0;
		
		return pair;
	}
	
	public static double highCard(Hand hand, Board board) {
		double highCard = 0;
		
		return highCard;
	}
	
	
	
	public static void main(String[] args) {
		Hand myFakeHand = new Hand(0);
		myFakeHand.add(new Card(Rank.of(6), Suit.HEARTS));
		myFakeHand.add(new Card(Rank.of(5), Suit.HEARTS));
		myFakeHand.add(new Card(Rank.of(10), Suit.DIAMONDS));
		myFakeHand.add(new Card(Rank.of(11), Suit.HEARTS));
		myFakeHand.add(new Card(Rank.of(12), Suit.SPADES));
		Board myFakeBoard = new Board(0);
		myFakeBoard.add(new Card(Rank.of(7), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(8), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(9), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(13), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(10), Suit.HEARTS));
		System.out.print(myFakeHand.hand);
		myFakeHand.hand.sort(Card.rankComparator);
		System.out.println();
		System.out.print(myFakeHand.hand);
		System.out.println();
		System.out.print(flush(myFakeHand, myFakeBoard));
//		System.out.print(HandRankingsBigO.straightFlush(myFakeHand, myFakeBoard));
	}
}
