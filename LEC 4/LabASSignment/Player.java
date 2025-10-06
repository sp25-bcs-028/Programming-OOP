import java.util.Scanner;
public class Player{
	String name;
	int score;
	Card startingHand[];
	public Player(){
	}	
	public Player(String name){
		this.name = name;
		this.score = 0;
		this.startingHand = null;
		
	}
	public void addPlayer(int numberOfPlayers){
		Player players [] = new Player[numberOfPlayers];
		Scanner scanner = new Scanner(System.in); 
		for(int i = 0; i < numberOfPlayers; i++){
			System.out.println("Enter the name of player: ");
			name = scanner.nextLine();
			players[i] = new Player(name); 
		}	
	}
	public Player[] getPlayers(){
		return players;		
	}	 
	public void displayPlayer()	 
}