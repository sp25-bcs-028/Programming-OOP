public class Screen {
	String screenType;
	double price_Premium = 1500;
	double price_Recliner = 1200;
	double price_Standard = 650;
	double price_VIP = 2500;
	int default_Rows = 10;
	Seat seats[][];
	SeatType seatTypes[] = SeatType.values();

	public Screen(String screenType, int numberOfColumns) {
		this.screenType = screenType;
		seats = new Seat[5][];
		for (int i = 0; i < seats.length; i++) {
			seats[i] = new Seat[numberOfColumns];
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = new Seat(String.format("%d %03d", i, j), seatTypes[0], true, 650);
			}
		}
		// seats[0][1].bookSeat();
		// seats[0][2].getId();
		// seats[1][1].setPtice(800);
		// seats[1][1].setSeatType(seatTypes[2]);
		// seats[0][1].cancelBooking();
	}

	public Screen(String screenType) {
		this.screenType = screenType;
		int numberOfCloumns[] = defaultRowSize(5);
		seats = new Seat[numberOfCloumns.length][];
		for (int i = 0; i < seats.length; i++) {
			seats[i] = new Seat[numberOfCloumns[i]];
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = new Seat(String.format("%d %03d", i, j), seatTypes[0], true, 650);
			}
		}
		// seats[0][1].bookSeat();
		// seats[0][2].getId();
		// seats[1][1].setPtice(800);
		// seats[1][1].setSeatType(seatTypes[2]);
		// seats[0][1].cancelBooking();
	}

	public String getScreenName() {
		return this.screenType;
	}

	public void displayLayout() {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print("[" + seats[i][j].getId() + (seats[i][j].getIsAvailable() ? " A" : " B") + "] ");
			}
			System.out.println("\n");
		}
		System.out.println();
	}

	public void displayVerbouse() {
		System.out.println("Total Seats: " + getTotalSeats() + " | Available Seats: " + getAvailableSeats() + " | Booked Seats: " + (getTotalSeats() - getAvailableSeats()));
		System.out.println("Pricing: Silver - Rs " + price_Standard + ", Gold - Rs " + price_Premium + ", Platinum - Rs " + price_VIP);
		for (int i = 0; i < seats.length; i++) {
			System.out.println("Row: " + (i + 1));
			for (int j = 0; j < seats[i].length; j++) { 
				System.out.print("[" + seats[i][j].getId() + (seats[i][j].getIsAvailable() ? " A" : " B") + "  Rs " + seats[i][j].getPrice() +"] ");
		}
			System.out.println("\n");
		}
		System.out.println("Seat Type Summary: ");
		System.out.println(getAvailableSeatsBySeatType());
		System.out.println();
	}

	public void bookById(String id) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].getId().equals(id)) {
					seats[i][j].bookSeat();
					return;
				}
			}
		}
	}

	public void bookBySeatNumber(int column, int row) {
		seats[column][row].bookSeat();
		return;
	}

	public void cancelById(String id) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].getId().equals(id)) {
					seats[i][j].cancelBooking();
					return;
				}
			}
		}
	}

	public void cancelBySeatNumber(int column, int row) {
		seats[column][row].cancelBooking();
		return;
	}

	public void getSeatById(String id) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].getId().equals(id)) {
					System.out.println(seats[i][j]);
					return;
				}
			}
		}
	}

	public void getSeatBySeatNumber(int column, int row) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (i == column && j == row) {
					System.out.println(seats[i][j]);
					return;
				}
			}
		}
	}

	public int getAvailableSeats() {
		int count = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].getIsAvailable()) {
					count++;
				}
			}
		}
		return count;
	}

	public String getAvailableSeatsBySeatType() {
		int silver = 0;
		int gold = 0;
		int platinum = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].getIsAvailable() && seats[i][j].getSeatType() == SeatType.Silver) {
					silver++;
				} else if (seats[i][j].getIsAvailable() && seats[i][j].getSeatType() == SeatType.Gold) {
					gold++;
				} else if (seats[i][j].getIsAvailable() && seats[i][j].getSeatType() == SeatType.Platinum) {
					platinum++;
				}
			}
		}
		if (silver <= 0 && gold <= 0 && platinum <= 0) {
			return "No Seats Available";
		}
		return this.screenType + " Available Seats - Silver: " + silver + ", Gold: " + gold + ", Platinum: " + platinum;
	}

	public int getTotalSeats() {
		int count = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				count++;
			}
		}
		return count;
	}

	public String getAvailableSeatBySeatType(SeatType seatType) {
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].getIsAvailable() && seats[i][j].getSeatType() == seatType) {
					return seats[i][j].toString();
				}
			}
		}
		return "No Seats Available of type: " + seatType;
	}

	public String getAvailableSeatsBySeatType(SeatType seatType) {
		int count = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				if (seats[i][j].getIsAvailable() && seats[i][j].getSeatType() == seatType) {
					count++;
				}
			}
		}
		if (count > 0) {
			return "Available Seats of type " + seatType + " : " + count;
		}
		return "No Seats Available of type: " + seatType;
	}

	public int getRowCount() {
		return seats.length;
	}

	public int getSeatsInRow(int row) {
		return seats[row].length;
	}

	public void setSeat(int row, SeatType seatType, double price) {
		for (int j = 0; j < seats[row].length; j++) {
			seats[row][j].setSeatType(seatType);
			seats[row][j].setPrice(price);
		}
	}

	public void checkRow(int row) {
		if (row < 0 || row >= seats.length) {
			throw new IllegalArgumentException("Invalid Row" + row);
		}
	}

	public int[] defaultRowSize(int numberOfRows) {
		int rows[] = new int[numberOfRows];
		for (int i = 0; i < numberOfRows; i++) {
			rows[i] = 6 + (i * 2);
		}
		return rows;
	}

	public void getSeatTypeFor(int row, int cloumn) {
		System.out.println(seats[row][cloumn].getSeatType());
	}

	public void getPriceFor(int row, int cloumn) {
		System.out.println(seats[row][cloumn].getPrice());
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Screen Type: " + screenType);
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				str.append("\n" + seats[i][j].toString());
			}
		}
		return str.toString();
	}
}