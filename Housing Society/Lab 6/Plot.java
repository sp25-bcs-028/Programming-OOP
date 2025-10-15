public class Plot{
	private String id;
	private PlotTypes plotType;
	private Boolean availability;
	private Shapes shape;
	private Double area;
	private double RES_5_MARLA = 4000000; 
	private double RES_10_MARLA = 7500000; 
	private double RES_1_KANAL = 14000000;
	private double COMM_SHOP = 3000000;
	private double COMM_OFFICE = 5000000;
	private double PARKING = 200000;
	private double plotPrice;

	public Plot(String id, PlotTypes plotType, Boolean availability){
		this.id = id;
		this.plotType = plotType;
		this.availability = availability;
	}	
}