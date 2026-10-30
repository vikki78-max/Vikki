public class FlightSegment extends Segment {
    private String flightNo;
    private String origin;
    private String destination;
    private String departTime;
    private String arriveTime;
    private double fare;

    public FlightSegment(String flightNo, String origin,
                         String destination, String departTime,
                         String arriveTime, String startDate,
                         String endDate, double fare) {
        super("Flight " + flightNo, startDate, endDate, fare);
        this.flightNo = flightNo;
        this.origin = origin;
        this.destination = destination;
        this.departTime = departTime;
        this.arriveTime = arriveTime;
        this.fare = fare;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setFare(double fare) {
        this.fare = fare;
        this.cost = fare;
    }

    @Override
    public double estimateCost() {
        return fare;
    }

    @Override
    public void printDetails() {
        System.out.println("Flight: " + flightNo
                + " | " + origin + " to " + destination
                + " | Departure: " + departTime
                + " | Arrival: " + arriveTime
                + " | Date: " + startDate
                + " | Fare: Rs." + estimateCost());
    }
}
