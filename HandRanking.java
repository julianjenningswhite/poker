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
	
	public static int rankTexasHoldem(HoleCards holeCards, Board board) {
		ArrayList<Card> cards = new ArrayList<Card>();
		for (Card card : holeCards.holeCards) {
			cards.add(card);
		}
		for (Card card : board.board) {
			cards.add(card);
		}
		
		int[] ranks = new int[cards.size()];
		cards.sort(Card.rankComparator);
		for (int i = 0; i < cards.size(); i++) {
			ranks[i] = cards.get(i).rank.getValue();
		}
		
		HashMap<Suit, Integer> suitsMap = new HashMap<Suit, Integer>();
		HashMap<Rank, Integer> ranksMap = new HashMap<Rank, Integer>();
		for (Card card : cards) {
			if (suitsMap.containsKey(card.suit)) {
				suitsMap.replace(card.suit, suitsMap.get(card.suit) + 1);
			} else {
				suitsMap.put(card.suit, 1);
			}
			
			if (ranksMap.containsKey(card.rank)) {
				ranksMap.replace(card.rank, ranksMap.get(card.rank)+ 1);
			} else {
				ranksMap.put(card.rank, 1);
			}
		}
		System.out.println(suitsMap);
		System.out.println(ranksMap);
 		
		
		
		cards.sort(Card.rankComparator);
		
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
		
		if (frequencyToRanks.containsKey(4)) {
			System.out.println("FOUR OF A KIND");
			return 8;
		}

		
		if (frequencyToRanks.containsKey(3) && frequencyToRanks.containsKey(2)) {
			System.out.println("FULL HOUSE");
			return 7;
		}
		
		cards.sort(Card.rankComparator);
		cards.sort(Card.suitComparator);
		if (cards.get(0).suit == cards.get(4).suit || cards.get(1).suit == cards.get(5).suit || cards.get(2).suit == cards.get(6).suit) {
			System.out.println("FLUSH");
			return 6;
		} else if (frequencyToRanks.containsKey(3)) {
			System.out.println("THREE OF A KIND");
			return 4;
		} else if (frequencyToRanks.containsKey(2) && frequencyToRanks.get(2).size() > 1) {
			System.out.println("TWO PAIR");
			return 3;
		} else if (frequencyToRanks.containsKey(2)) {
			System.out.println("PAIR");
			return 2;
		} else {
			System.out.println("HIGH CARD");
			return 1;
		}
	}
}
