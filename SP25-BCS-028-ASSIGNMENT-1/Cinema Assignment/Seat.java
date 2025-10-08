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
		return "ID: " + " " + this.id + "          " +"SeatType: " + seatType + "  " + "Price: " + price + "  " + "Available: " + isAvailable;
	}
	public void bookSeat(){
		this.isAvailable = false;
	}
	public String getId(){
		return this.id;
	}
	public SeatType getSeatType(){
		return this.seatType;
	}
	public boolean getIsAvailable(){
		return this.isAvailable;
	}
	public double getPrice(){
		return this.price;
	}
	public void cancelBooking(){
		this.isAvailable = true;
	}
	public void setSeatType(SeatType seatType){
		this.seatType = seatType;
	}
	public void setPrice(double price){
		this.price = price;
	}
	@Override
	public boolean equals(Object obj){
		return this.id.equals(((Seat)obj).id);
	}
}	