public class HotelBooking extends Segment {
    private String hotelName;
    private String city;
    private String checkIn;
    private String checkOut;
    private double nightlyRate;

    public HotelBooking(String hotelName, String city,
                        String checkIn, String checkOut,
                        String startDate, String endDate,
                        double nightlyRate) {
        super("Hotel " + hotelName, startDate,
                endDate, nightlyRate);
        this.hotelName = hotelName;
        this.city = city;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.nightlyRate = nightlyRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getCity() {
        return city;
    }

    public void setNightlyRate(double rate) {
        nightlyRate = rate;
        cost = rate;
    }

    @Override
    public double estimateCost() {
        try {
            java.time.LocalDate in =
                    java.time.LocalDate.parse(checkIn);
            java.time.LocalDate out =
                    java.time.LocalDate.parse(checkOut);
            long nights = java.time.temporal.ChronoUnit
                    .DAYS.between(in, out);
            return Math.max(0, nights) * nightlyRate;
        } catch (Exception e) {
            return nightlyRate;
        }
    }

    @Override
    public void printDetails() {
        System.out.println("Hotel: " + hotelName
                + " | City: " + city
                + " | Check-in: " + checkIn
                + " | Check-out: " + checkOut
                + " | Cost: Rs." + estimateCost());
    }
}
