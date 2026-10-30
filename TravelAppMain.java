public class TravelAppMain {
    public static void main(String[] args) {
        Itinerary trip = new Itinerary(
                "TR101",
                "Vignesh",
                "2026-11-10",
                "2026-11-13"
        );

        TravelService service = new TravelService(trip);

        // Add flights
        service.addFlight(new FlightSegment(
                "AI101", "Chennai", "Delhi",
                "08:00", "11:00",
                "2026-11-10", "2026-11-10", 5500));

        // Add a flight using the overloaded method
        service.addFlight(
                "AI202", "Delhi", "Chennai", 6000);

        // Add hotel booking
        service.addHotel(new HotelBooking(
                "Grand Palace",
                "Delhi",
                "2026-11-10",
                "2026-11-13",
                "2026-11-10",
                "2026-11-13",
                2500
        ));

        service.optimizeCosts();
        service.printPlan();

        System.out.println("\nRemoving flight AI202...");
        boolean removed = service.removeSegment("Flight AI202");
        System.out.println("Segment removed: " + removed);

        service.printPlan();

        System.out.println("\nServices created: "
                + TravelService.getServiceCount());
    }
}
