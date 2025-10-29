// SocietyDemo.java
public class SocietyDemo{
    public static void main(String[] args) {
        CityHousing lahore = new CityHousing();
        
        System.out.println("=== HOUSING SOCIETY MANAGEMENT SYSTEM ===");
        
        // Test 1: Book a plot
        System.out.println("\n--- Test 1: Booking Plot ---");
        boolean booked = lahore.bookPlot("LDA Avenue 1", "A", "3-007");
        System.out.println("Booking plot 3-007 in LDA Avenue 1, Block A: " + (booked ? "SUCCESS" : "FAILED"));
        
        // Test 2: Try to book same plot again
        System.out.println("\n--- Test 2: Duplicate Booking ---");
        booked = lahore.bookPlot("LDA Avenue 1", "A", "3-007");
        System.out.println("Duplicate booking attempt: " + (booked ? "SUCCESS" : "FAILED (expected)"));
        
        // Test 3: Cancel booking
        System.out.println("\n--- Test 3: Cancel Booking ---");
        boolean cancelled = lahore.findSociety("LDA Avenue 1").cancelPlot("A", "3-007");
        System.out.println("Cancel booking: " + (cancelled ? "SUCCESS" : "FAILED"));
        
        // Test 4: Print layouts
        System.out.println("\n--- Test 4: Society Layouts ---");
        lahore.printAllLayouts();
        
        // Test 5: Find corner plot
        System.out.println("\n--- Test 5: Search for Corner Plot ---");
        String cornerPlot = lahore.findFirstAvailableCornerPlot();
        System.out.println("First available corner plot: " + cornerPlot);
        
        // Test 6: Detailed block info
        System.out.println("\n--- Test 6: Detailed Block Information ---");
        lahore.findSociety("LDA Avenue 1").findBlock("A").printDetailedInfo();
        
        // Test 7: Available shops in market
        System.out.println("\n--- Test 7: Available Shops ---");
        HousingSociety society = lahore.findSociety("LDA Avenue 1");
        Block blockC = society.findBlock("C");
        Shop[] availableShops = blockC.getMarket().getAvailableShops();
        System.out.println("Available shops in Block C market:");
        for(int i = 0; i < Math.min(3, availableShops.length); i++) {
            System.out.println("  " + availableShops[i]);
        }
    }
}