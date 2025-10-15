public class Plot{
	private String id;
	private PlotTypes plotType;
	private Boolean availability;
	private Shapes shape;
	private Double area;
	private double plotPrice;

	public Plot(String id, PlotTypes plotType, Boolean availability){
		this.id = id;
		this.plotType = plotType;
		this.availability = availability;
	}
	public double getPrice(String id){
		return this.plotPrice;
	}
	public String getId(){
		return this.id;

	}
	public void bookPlot(){
		retrun this.availability = false;
	}
	public void cancelBooking(){
		retrun this.availability = true;
	}	
	public String toString(){
		return String.format("Plot Type: ")
	}
}