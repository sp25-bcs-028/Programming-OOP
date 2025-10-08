public class Demo{
	public static void main(String args[]){
		//Seat seat = new Seat("001", SeatType.Silver, true, 320.00);
		// //System.out.println(seat);
		// System.out.println(ScreenType.IMAX.value);
		// Screen screen = new Screen(ScreenType.IMAX.value, 5);
		// System.out.println(screen);
		// screen.bookById("0 001");
		// System.out.println(screen);
		// System.out.println("After Booking: " + screen.getAvailableSeatsBySeatType());
		Cinema cinema = new Cinema("Bangalore", 3);
		cinema.displayVerbouse();
		// System.out.println(cinema);
	}
}