import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HandRanking {
	public static int rank(HoleCards holeCards, Board board, GameType gameType) {
		if (gameType == GameType.TEXAS_HOLDELM) {
			return rankTexasHoldem(holeCards, board);
		}
		
		return 0;
	}
	
	public static int rankFiveCards(ArrayList<Card> cards) { // TODO handle Ace on both sides for straights
		HashMap<Rank, Integer> ranksMap = new HashMap<Rank, Integer>();
		for (Card card : cards) {
			if (ranksMap.containsKey(card.rank)) {
				ranksMap.replace(card.rank, ranksMap.get(card.rank)+ 1);
			} else {
				ranksMap.put(card.rank, 1);
			}
		}
		
		HashMap<Integer, LinkedList<Rank>> frequencyToRanks = new HashMap<Integer, LinkedList<Rank>>();
		for(Map.Entry<Rank, Integer> entry : ranksMap.entrySet()){
			if (frequencyToRanks.containsKey(entry.getValue())) {
				frequencyToRanks.get(entry.getValue()).add(entry.getKey());
			} else {
				LinkedList<Rank> list = new LinkedList<Rank>();
				list.add(entry.getKey());
				frequencyToRanks.put(entry.getValue(), list);
			}
		}
		
		cards.sort(Card.rankComparator);
		cards.sort(Card.suitComparator);
		if (cards.get(0).suit == cards.get(4).suit) {
			if (cards.get(0).rank.value + 1 == cards.get(1).rank.value && cards.get(1).rank.value + 1 == cards.get(2).rank.value && cards.get(2).rank.value + 1 == cards.get(3).rank.value && cards.get(3).rank.value + 1 == cards.get(4).rank.value) {
				System.out.println("STRAIGHT FLUSH");
				return 9;
			}
		}
		
		if (frequencyToRanks.containsKey(4)) {
			System.out.println("FOUR OF A KIND");
			return 8;
		}
		
		if (frequencyToRanks.containsKey(3) && frequencyToRanks.containsKey(2)) {
			System.out.println("FULL HOUSE");
			return 7;
		}
		
		if (cards.get(0).suit == cards.get(4).suit) {
			System.out.println("FLUSH");
			return 6;
		}
		
		cards.sort(Card.rankComparator);
		System.out.println(cards);
		if (cards.get(0).rank.value + 1 == cards.get(1).rank.value && cards.get(1).rank.value + 1 == cards.get(2).rank.value && cards.get(2).rank.value + 1 == cards.get(3).rank.value && cards.get(3).rank.value + 1 == cards.get(4).rank.value) {
			System.out.println("STRAIGHT");
			return 5;
		}
		
		if (frequencyToRanks.containsKey(3)) {
			System.out.println("THREE OF A KIND");
			return 4;
		}
		
		if (frequencyToRanks.containsKey(2) && frequencyToRanks.get(2).size() > 1) {
			System.out.println("TWO PAIR");
			return 3;
		} 
		
		if (frequencyToRanks.containsKey(2)) {
			System.out.println("PAIR");
			return 2;
		}
		
		System.out.println("HIGH CARD");
		return 1;
	}
	
	public static int rankTexasHoldem(HoleCards holeCards, Board board) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (Card card : holeCards.holeCards) {
			cards.add(card);
		}
		for (Card card : board.board) {
			cards.add(card);
		}
		
		HashMap<Rank, Integer> ranksMap = new HashMap<Rank, Integer>();
		for (Card card : cards) {
			if (ranksMap.containsKey(card.rank)) {
				ranksMap.replace(card.rank, ranksMap.get(card.rank)+ 1);
			} else {
				ranksMap.put(card.rank, 1);
			}
		}
 		
		HashMap<Integer, LinkedList<Rank>> frequencyToRanks = new HashMap<Integer, LinkedList<Rank>>();
		for(Map.Entry<Rank, Integer> entry : ranksMap.entrySet()){
			if (frequencyToRanks.containsKey(entry.getValue())) {
				frequencyToRanks.get(entry.getValue()).add(entry.getKey());
			} else {
				LinkedList<Rank> list = new LinkedList<Rank>();
				list.add(entry.getKey());
				frequencyToRanks.put(entry.getValue(), list);
			}
		}
		
		cards.sort(Card.rankComparator);
		cards.sort(Card.suitComparator);
		for (int offset = 0; offset <= 2; offset++) {
			if (cards.get(offset).suit == cards.get(offset + 4).suit) {
				if (cards.get(offset).rank.value + 1 == cards.get(offset + 1).rank.value && cards.get(offset + 1).rank.value + 1 == cards.get(offset + 2).rank.value && cards.get(offset + 2).rank.value + 1 == cards.get(offset + 3).rank.value && cards.get(offset + 3).rank.value + 1 == cards.get(offset + 4).rank.value) {
					System.out.println("STRAIGHT FLUSH");
					return 9;
				}
			}
		}
		
		if (frequencyToRanks.containsKey(4)) {
			System.out.println("FOUR OF A KIND");
			return 8;
		}
		
		if (frequencyToRanks.containsKey(3) && frequencyToRanks.containsKey(2)) {
			System.out.println("FULL HOUSE");
			return 7;
		}
		
		for (int offset = 0; offset <= 2; offset++) {
			if (cards.get(offset).suit == cards.get(offset + 4).suit) {
				System.out.println("FLUSH");
				return 6;
			}
		}
		
		cards.sort(Card.rankComparator); // TODO not complete
		System.out.println(cards);
		for (int offset = 0; offset <= 2; offset++) {
			if (cards.get(offset).rank.value == 1) {
				System.out.println("STRAIGHT");
				return 5;
			}
		}
		
		if (frequencyToRanks.containsKey(3)) {
			System.out.println("THREE OF A KIND");
			return 4;
		}
		
		if (frequencyToRanks.containsKey(2) && frequencyToRanks.get(2).size() > 1) {
			System.out.println("TWO PAIR");
			return 3;
		} 
		
		if (frequencyToRanks.containsKey(2)) {
			System.out.println("PAIR");
			return 2;
		}
		
		System.out.println("HIGH CARD");
		return 1;
	}
}
