public class BigO {
	public static int bestHand(Hand hand, Board board) { // expect numerical value of best hand
		int ranking = 0;
		for (int i = 0; i < hand.hand.size(); i++) {
			for (int j = i + 1; j < hand.hand.size(); j++) {
				Hand playHand = new Hand(2);
				playHand.add(hand.hand.get(i));
				playHand.add(hand.hand.get(j)); // compute numerical value elsewhere, here just get the highest numerical value
				if (straightFlush(playHand, board) != 0) {
					ranking = straightFlush(playHand, board);
				} else if (quads(playHand, board) != 0) {
					ranking = quads(playHand, board);
				} else if (fullHouse(playHand, board) != 0) {
					ranking = fullHouse(playHand, board);
				} else if (flush(playHand, board) != 0) {
					ranking = flush(playHand, board);
				} else if (staight(playHand, board) != 0) {
					ranking = staight(playHand, board);
				} else if (threeOfAKind(playHand, board) != 0) {
					ranking = threeOfAKind(playHand, board);
				} else if (twoPair(playHand, board) != 0) {
					ranking = twoPair(playHand, board);
				} else if (pair(playHand, board) != 0) {
					ranking = pair(playHand, board);
				} else if (highCard(playHand, board) != 0) {
					ranking = highCard(playHand, board);
				}
			}
		return ranking;
	}
	
	
	public static void main(String[] args) {
		Hand myFakeHand = new Hand(0);
		myFakeHand.add(new Card(Rank.of(5), Suit.HEARTS));
		myFakeHand.add(new Card(Rank.of(6), Suit.HEARTS));
		myFakeHand.add(new Card(Rank.of(10), Suit.DIAMONDS));
		myFakeHand.add(new Card(Rank.of(11), Suit.HEARTS));
		myFakeHand.add(new Card(Rank.of(12), Suit.SPADES));
		Board myFakeBoard = new Board(0);
		myFakeBoard.add(new Card(Rank.of(7), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(8), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(9), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(13), Suit.HEARTS));
		myFakeBoard.add(new Card(Rank.of(10), Suit.HEARTS));
		System.out.print(myFakeBoard);
		System.out.println();
		System.out.print(HandRankingsBigO.straightFlush(myFakeHand, myFakeBoard));
	}
}
