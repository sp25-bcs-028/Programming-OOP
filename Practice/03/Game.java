public class Game{
	Deck deck = new Deck();
	public Game(){
		deck.display();
		deck.shuffle();
		deck.display();
	}
}