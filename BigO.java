import java.util.Collections;

public class BigO {
	
	public static void main(String[] args) {
		Deck testDeck = new Deck();
		Hand myTestHand = new Hand(5);
		testDeck.toPrint();
		System.out.println();
		myTestHand.toPrint();
//		Hand myFakeTestHand = new Hand(2, false);
//		myFakeTestHand.toPrint();
	}
}


/*
public class BigO {
	public int isPair(Hand myHand) {
		int pairCounter = 0;
		int pairRank = 0;
		int secondPairRank = 0;
		for (int i = 0; i < 5; i++) {
			if ((Collections.frequency(Hand.handRankArray, hand[i].rank) == 2) && pairRank != hand[i].rank.getValue()) {
				pairCounter++;
				if (pairRank == 0)
					pairRank = hand[i].rank.getValue();
				else
					secondPairRank = hand[i].rank.getValue();
			}
		}
		return pairCounter;
	}
	
	public int isTriple(Hand myHand) {
		int tripleCounter = 0;
		int tripleRank = 0;
		for (int i = 0; i < 5; i++) {
			if ((Collections.frequency(handRankArray, hand[i].rank) == 3)) {
				tripleCounter++;
				tripleRank = hand[i].rank.getValue();
			}
		}
		return tripleCounter;
	}
	
	public int isQuads(Hand myHand) {
		int quadsCounter = 0;
		int quadsRank = 0;
		for (int i = 0; i < 5; i++) {
			if ((Collections.frequency(handRankArray, hand[i].rank) == 4)) {
				quadsCounter++;
				quadsRank = hand[i].rank.getValue();
			}
		}
		return quadsCounter;
	}
	
	public int isSuited(Hand myHand) {
		int suitedPairsCounter = 0;
		String pairSuit = "";
		String secondPairSuit = "";
		for (int i = 0; i < 5; i++) {
			if ((Collections.frequency(handSuitArray, hand[i].suit) == 2) && pairSuit != hand[i].suit.getDisplayName()) {
				suitedPairsCounter++;
				if (pairSuit == "")
					pairSuit = hand[i].suit.getDisplayName();
				else
					secondPairSuit = hand[i].suit.getDisplayName();
			}
		}
		return suitedPairsCounter;
	}
	
	public int isTripleSuited(Hand myHand) {
		int tripleSuitCounter = 0;
		int tripleSuit = 0;
		for (int i = 0; i < 5; i++) {
			if ((Collections.frequency(handRankArray, hand[i].rank) == 3)) {
				tripleSuitCounter++;
				tripleSuit = hand[i].rank.getValue();
			}
		}
		return tripleSuitCounter;
	}
	
	public int isFourSuited(Hand myHand) {
		int fourSuitedCounter = 0;
		int fourSuit = 0;
		for (int i = 0; i < 5; i++) {
			if ((Collections.frequency(handRankArray, hand[i].rank) == 3)) {
				fourSuitedCounter++;
				fourSuitedCounter = hand[i].rank.getValue();
			}
		}
		return fourSuitedCounter;
	}
	
	public int isFiveSuited(Hand myHand) {
		int fiveSuitedCounter = 0;
		int fiveSuit = 0;
		for (int i = 0; i < 5; i++) {
			if ((Collections.frequency(handRankArray, hand[i].rank) == 3)) {
				fiveSuitedCounter++;
				fiveSuit = hand[i].rank.getValue();
			}
		}
		return fiveSuitedCounter;
	}
}

*/