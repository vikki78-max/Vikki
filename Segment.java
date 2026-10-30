public abstract class Segment {
    protected String name;
    protected String startDate;
    protected String endDate;
    protected double cost;

    public Segment(String name, String startDate,
                   String endDate, double cost) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public abstract double estimateCost();

    public void printDetails() {
        System.out.println(name + " | " + startDate
                + " to " + endDate
                + " | Cost: Rs." + estimateCost());
    }
}
