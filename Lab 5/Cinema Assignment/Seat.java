public class Seat{
	SeatType seatType;
	String id;
	boolean isAvailable;
	double price;
	public Seat(String id, SeatType seatType, boolean isAvailable, double price){
		this.id = id;
		this.seatType = seatType;
		this.isAvailable = isAvailable;
		this.price = price;	
	}
	@Override
	public String toString(){
		return "ID: " + " " + this.id + "          " +"SeatType: " + seatType + "  " + "Price: " + price;
	}
}	