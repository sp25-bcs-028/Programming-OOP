public class Screen{
	String screenType;
	Seat seats[][];
	SeatType seatTypes[] = SeatType.values();
	public Screen(String screenType){
		seats = new Seat[5][];
		for(int i = 0; i < seats.length; i++){
			seats[i] = new Seat[5];
			for(int j = 0; j < seats[i].length; j++){
				seats[i][j] = new Seat(String.format("%d %03d", i, j), seatTypes[0], true, 650);
			}
		}
	}
	@Override	
	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append(screenType);
		for(int i = 0; i < seats.length; i++){
			for(int j = 0; j < seats[i].length; j++){
				str.append("\n" + seats[i][j].toString());
			}	
		}
	return str.toString();	
	}	
}	