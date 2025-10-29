public class Demo{
	public static void main(String args[]){
		Plot plot = new Plot(7, 34, PlotType.RES_10_MARLA, ShapeType.RECTANGLE, new double []{2.4,4.3});
		Plot plot2 = new CornerPlot(7, 34, PlotType.RES_10_MARLA, ShapeType.RECTANGLE, new double []{2.4,4.3},4.4);
		System.out.println(plot2);
	}	
}