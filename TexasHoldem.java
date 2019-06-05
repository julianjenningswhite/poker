
public class TexasHoldem {
	public static void main (String[] args) {
		System.out.println("Testing Texas Holdem");
		
		Deck deck = new Deck();
		HoleCards holeCards1 = new HoleCards(2);
		System.out.println(holeCards1);
	}
}
