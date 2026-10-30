public class TravelService {
    private Itinerary itinerary;
    private static int serviceCount = 0;

    public TravelService(Itinerary itinerary) {
        this.itinerary = itinerary;
        serviceCount++;
    }

    public void addFlight(FlightSegment flight) {
        itinerary.addSegment(flight);
    }

    // Method overloading
    public void addFlight(String flightNo, String origin,
                          String destination, double fare) {
        FlightSegment flight = new FlightSegment(
                flightNo, origin, destination,
                "09:00", "12:00",
                itinerary.getStartDate(),
                itinerary.getStartDate(), fare);
        addFlight(flight);
    }

    public void addHotel(HotelBooking hotel) {
        itinerary.addSegment(hotel);
    }

    public boolean removeSegment(String name) {
        return itinerary.removeSegment(name);
    }

    public double estimateCost() {
        itinerary.calculateTotal();
        return itinerary.getTotalCost();
    }

    public void optimizeCosts() {
        itinerary.calculateTotal();
        System.out.println("Cost calculation completed.");
    }

    public void printPlan() {
        itinerary.printItinerary();
        itinerary.printDayWisePlan();
    }

    public static int getServiceCount() {
        return serviceCount;
    }
}
