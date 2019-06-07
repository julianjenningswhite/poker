import java.util.ArrayList;
import java.util.Collections;

public class HandRankingsBigO {
	
	public static Card getHighestCard(ArrayList<Card> cards) {
		cards.sort(Card.rankComparator);
		if (cards.get(0).rank.getValue() == 1)
			return cards.get(0);
		else
			return cards.get(cards.size() - 1);
	}
	
	public static int findConsecutiveRanks(ArrayList<Integer> ranks) {
		int consecutivesRank = 0;
		Collections.sort(ranks);
		if (ranks.get(0) == 1 && ranks.get(ranks.size() - 1) == 13 && ranks.get(ranks.size() - 2) == 12
				 && ranks.get(ranks.size() - 3) == 11 && ranks.get(ranks.size() - 4) == 10) {
			consecutivesRank = 1;
		}
		for (int i = ranks.size() - 1; i > 3; i--) {
			if (ranks.get(i) - ranks.get(i - 1) == 1 && ranks.get(i - 1) - ranks.get(i - 2) == 1
					&& ranks.get(i - 2) - ranks.get(i - 3) == 1 && ranks.get(i - 3) - ranks.get(i - 4) == 1)
				if (consecutivesRank < ranks.get(i))
					consecutivesRank = ranks.get(i); // necessary in case of several straights with the same board
		}
		return consecutivesRank;
	}
	
	public static ArrayList<Integer> getRanks(ArrayList<Card> cards) {
		ArrayList<Integer> rankArray = new ArrayList<Integer>();
		for (int i = 0; i < cards.size(); i++)
			rankArray.add(cards.get(i).rank.getValue());
		return rankArray;
	}
	
	public static int straightFlush(Hand myHand, Board board) {
		int straightFlush = 0;
		if (HandRankingsBigO.flush(myHand, board) != 0) {
			ArrayList<Integer> handAndBoardFlushRanks = new ArrayList<Integer>();
			handAndBoardFlushRanks.addAll(HandRankingsBigO.getRanks(myHand.getSameSuit(flushSuit)));
			handAndBoardFlushRanks.addAll(HandRankingsBigO.getRanks(board.getSameSuit(flushSuit)));
			if (straightFlush < HandRankingsBigO.findConsecutiveRanks(handAndBoardFlushRanks))
				straightFlush = HandRankingsBigO.findConsecutiveRanks(handAndBoardFlushRanks); // necessary in case of several straight-flushes with the same board			
		}
		return straightFlush;
	}
	
	public static int straight(Hand myHand, Board board) {
		int straight = 0;
		for (int i = 0; i < myHand.hand.size(); i++) {
			for (int j = 1; j < myHand.hand.size(); j++) {
				ArrayList<Integer> handAndBoardRanks = new ArrayList<Integer>();
				handAndBoardRanks.add(myHand.getRanks().get(i));
				handAndBoardRanks.add(myHand.getRanks().get(j));
				handAndBoardRanks.addAll(board.getRanks());
				if (straight < HandRankingsBigO.findConsecutiveRanks(handAndBoardRanks))
					straight = HandRankingsBigO.findConsecutiveRanks(handAndBoardRanks); // necessary in case of several straights with the same board
			}
		}
		return straight;
	}
		
	static Suit flushSuit;
	public static int flush(Hand myHand, Board board) {
		int flushRank = 0;
		for (Suit suit : Suit.values()) {
			if (myHand.getSameSuit(suit).size() >= 2 && board.getSameSuit(suit).size() >= 3) {
				flushRank = HandRankingsBigO.getHighestCard(myHand.getSameSuit(suit)).rank.getValue();
				flushSuit = suit;
			}
		}
		return flushRank;
	}
	
	public static int quads(Hand myHand, Board board) {
		int quads = 0;
		for (Rank rank : Rank.values()) {
			if (Collections.frequency(myHand.getRanks(), rank) == 2 && Collections.frequency(board.getRanks(), rank) == 2) {
				if (quads != 1)
					quads = rank.getValue();
			}
		}
		return quads;
	}
	
	public static int set(Hand myHand, Board board) {
		int set = 0;
		for (Rank rank : Rank.values()) {
			if (Collections.frequency(myHand.getRanks(), rank) >= 2 && Collections.frequency(board.getRanks(), rank) == 1) {
				if (set != 1)
					set = rank.getValue();
			}
		}
		return set;
	}
}
