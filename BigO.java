import java.util.ArrayList;
import java.util.HashMap;
public class BigO {
	
	public static double bestHighHand(Hand hand, Board board) {
		double ranking = 0;
		ArrayList<Card> playCards = new ArrayList<Card>();
		for (int i = 0; i < hand.hand.size(); i++) {
			for (int j = i + 1; j < hand.hand.size(); j++) {
				for (int k = 0; k < board.board.size(); k++) {
					for (int m = k + 1; m < board.board.size(); m++) {
						for (int n = m + 1; n < board.board.size(); n++) {
							playCards.removeAll(playCards);
							playCards.add(hand.hand.get(i));
							playCards.add(hand.hand.get(j));
							playCards.add(board.board.get(k));
							playCards.add(board.board.get(m));
							playCards.add(board.board.get(n)); 
							double thisCombinationRank = HandRanking.rankFiveCards(playCards);
							if (ranking < thisCombinationRank)
								ranking = thisCombinationRank;
						}
					}
				}
			}
		}
		return ranking;
	}
	
	public static int bestLowHand(Hand Hand, Board board) {
		int ranking = 0;
		return ranking;
	}
	
	public static double highWinner(Hand hand1, Hand hand2, Hand hand3, Hand hand4, Hand hand5, Hand hand6, Hand hand7, Hand hand8, Board board) {
		double[] highScores = new double[9];
		highScores[0] = bestHighHand(hand1, board);
		highScores[1] = bestHighHand(hand2, board);
		highScores[2] = bestHighHand(hand3, board);
		highScores[3] = bestHighHand(hand4, board);
		highScores[4] = bestHighHand(hand5, board);
		highScores[5] = bestHighHand(hand6, board);
		highScores[6] = bestHighHand(hand7, board);
		highScores[7] = bestHighHand(hand8, board);
		double max = 0;
		int winningHand = 0;
		for (int i = 0; i < 8; i++) {
//			System.out.println("Hand no. " + (i + 1) + " has a score of: " + highScores[i]);
			if (max < highScores[i]) {
				max = highScores[i];
				winningHand = i + 1;
			}
		}
//		return "The high winner is hand no. " + winningHand + ", with a score of: " + max;
		return max;
	}
	
	public static int analysis() {
		Deck deck = new Deck();
		Hand hand1 = new Hand(deck,5);
		Hand hand2 = new Hand(deck,5);
		Hand hand3 = new Hand(deck,5);
		Hand hand4 = new Hand(deck,5);
		Hand hand5 = new Hand(deck,5);
		Hand hand6 = new Hand(deck,5);
		Hand hand7 = new Hand(deck,5);
		Hand hand8 = new Hand(deck,5);
		Board board = new Board(deck);
		return (int) highWinner(hand1, hand2, hand3, hand4, hand5, hand6, hand7, hand8, board);
	}
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		for (int i = 0; i < 100; i++) {
			int result = analysis();
			if (frequency.containsKey(result))
				frequency.put(result, frequency.get(result) + 1);
			else
				frequency.put(result, 1);
		}
		System.out.println(frequency);
	}
}

