public class Card{
	private final Suite suit;
	private final Rank rank;
	Card(Suite suit, Rank rank){
		this.suit=suit;
		this.rank=rank;
	}
	public String toString(){
		return "Rank: " + this.rank + "Suit: " + this .suit;
	}
}