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
	
	public static double highWinner(ArrayList<Hand> hands, Board board) {
		ArrayList<Double> highScores = new ArrayList<Double>();
		for (Hand hand : hands) {
			highScores.add(bestHighHand(hand, board));
		}
		
		double highestScore = 0;
		int winningHand = 0;
		int i = 0;
		for (Double highScore : highScores) {
			// System.out.println("Hand no. " + (i + 1) + " has a score of: " + highScore);
			if (highestScore < highScore) {
				highestScore = highScore;
				winningHand = i + 1;
			}
			i++;
		}
		// System.out.println("The high winner is hand no. " + winningHand + ", with a score of: " + highestScore);
		
		return highestScore;
	}
	
	public static int analysis() {
		int numberOfHands = 8;
		Deck deck = new Deck();
		ArrayList<Hand> hands = new ArrayList<Hand>();
		for (int i = 0; i < numberOfHands; i++) {
			hands.add(new Hand(deck, 5));
		}
		Board board = new Board(deck);
		return (int) highWinner(hands, board);
	}
	
	public static void main(String[] args) {
		HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
		for (int i = 0; i < 1000; i++) {
			int result = analysis();
			if (frequency.containsKey(result))
				frequency.put(result, frequency.get(result) + 1);
			else
				frequency.put(result, 1);
		}
		System.out.println(frequency);
	}
}

