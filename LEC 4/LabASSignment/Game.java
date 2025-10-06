public class Game{
	Deck deck = new Deck();
	Player player = new Player();
	public Game(){
		deck.display();
		deck.shuffle();
		deck.display();
		player.addPlayer(4);
	}
	public void distributeCards(int numberOfPlayers){
		deck.shuffle();
		Card cards[] = deck.getcards();
		Player players[] = player.getPlayers;
		int capacity = (cards.length/numberOfPlayers);
		for(int i = 0; i < numberOfPlayers; i++){
			for(int j = 0; j < capacity; j++){
				player[0].startingHand = new Card cards[j];
			}
		}
	}	
}
