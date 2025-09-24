import java.util.Random;
public class Deck{
	Card cards [];
	Deck(){
		cards = new Card[52];
		Suite suits[] = Suite.values();
		Rank ranks[] = Rank.values();
		int counter = 0;

		for(int i = 0; i < suits.length; i++){
			for(int j = 0; j < ranks.length; j++){
				cards[counter++] = new Card(suits[i], ranks[j]);
			}
		}
	}
	public void display(){
		for(int i = 0; i < cards.length; i++){
			System.out.println(cards[i]);
		}	
	}
	public void shuffle(){
		for(int i=0;i<5000;i++){
			Random rand=new Random();
			int ran=rand.nextInt(52);
			Card temp=cards[ran];
			cards[ran]=cards[0];
			cards[0]=temp;
		}
	}

}
