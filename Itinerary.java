import java.util.ArrayList;
import java.util.List;

public class Itinerary {
    private String itineraryId;
    private String traveler;
    private List<Segment> segments;
    private double totalCost;
    private String startDate;
    private String endDate;

    public Itinerary(String itineraryId, String traveler,
                     String startDate, String endDate) {
        this.itineraryId = itineraryId;
        this.traveler = traveler;
        this.startDate = startDate;
        this.endDate = endDate;
        segments = new ArrayList<>();
        totalCost = 0;
    }

    public String getItineraryId() {
        return itineraryId;
    }

    public String getTraveler() {
        return traveler;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public List<Segment> getSegments() {
        return new ArrayList<>(segments);
    }

    public void addSegment(Segment segment) {
        segments.add(segment);
        calculateTotal();
    }

    public boolean removeSegment(String name) {
        boolean removed = segments.removeIf(
                s -> s.getName().equalsIgnoreCase(name));
        calculateTotal();
        return removed;
    }

    public void calculateTotal() {
        totalCost = 0;
        for (Segment s : segments) {
            totalCost += s.estimateCost();
        }
    }

    public void printItinerary() {
        System.out.println("\n========== TRAVEL ITINERARY ==========");
        System.out.println("ID: " + itineraryId);
        System.out.println("Traveler: " + traveler);
        System.out.println("Trip: " + startDate + " to " + endDate);
        System.out.println("--------------------------------------");
        for (Segment s : segments) {
            s.printDetails();
        }
        calculateTotal();
        System.out.printf("TOTAL COST: Rs.%.2f%n", totalCost);
        System.out.println("======================================");
    }

    public void printDayWisePlan() {
        System.out.println("\n========== DAY-WISE PLAN ==========");
        for (Segment s : segments) {
            System.out.println(s.getStartDate() + ": "
                    + s.getName() + " (Rs."
                    + String.format("%.2f", s.estimateCost())
                    + ")");
        }
        System.out.println("===================================");
    }
}
