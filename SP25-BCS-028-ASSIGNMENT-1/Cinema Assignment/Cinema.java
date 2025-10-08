public class Cinema{
	String cityName;
	int numberOfScreens;
	Screen[] screens;
	public Cinema(String cityName, int numberOfScreens){
		this.cityName = cityName;
		this.numberOfScreens = numberOfScreens;
		screens = new Screen[numberOfScreens];
		for(int i = 0; i < numberOfScreens; i++){
			screens[i] = new Screen(ScreenType.HD.value);
		}
	}
	public void displayLayout(){
		System.out.println("=== City: " + cityName + " | All Cinema Layouts ===");
		for(int i = 0; i < screens.length; i++){
			System.out.println("=== Cinema: Cinema-" + i + 1 + " | Layouts ===");
			for(int j = 0; j < screens[i].getRowCount(); j++){
				System.out.println("=== Screen: Screen-" + j + 1 + " | Layouts ===");
				screens[i].displayLayout();
				// System.out.println("\n");
			}
		}
		System.out.println("Legend: A - Available, B - Booked");
	}
	public void displayVerbouse(){
		System.out.println("=== City: " + cityName + " | All Cinema Layouts ===");
		for(int i = 0; i < screens.length; i++){
			System.out.println("=== Cinema: Cinema-" + i + 1 + " | Layouts ===");
			for(int j = 0; j < screens[i].getRowCount(); j++){
				System.out.println("=== Screen: Screen-" + j + 1 + " | Layouts ===");
				screens[i].displayVerbouse();
				// System.out.println("\n");
			}
		}
		System.out.println("Legend: A - Available, B - Booked");
	}
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("City: " + cityName);
		for (int i = 0; i < screens.length; i++) {
			str.append("\n" + screens[i].toString());
			
		}
		return str.toString();
	}
}