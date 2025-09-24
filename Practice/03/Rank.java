public enum Rank{
	Ace("Ace", 1),Two("Two", 2),Three("Three", 3),Four("Four", 4),Five("Five", 5),Six("Six", 6),Seven("Seven", 7),Eight("Eight", 8),Nine("Nine", 9),Ten("Ten", 10),Jack("Jack", 11),Queen("Queen", 12),King("King", 13);
	String name;
	int value;
	Rank(String name, int value){
		this.name = name;
		this.value = value;
	}
	public String getName(){
		return name;
	}
	public int getValue(){
		return value;
	}
}