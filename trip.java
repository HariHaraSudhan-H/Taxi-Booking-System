public class trip {
    static int i = 1;
    private int BookingID;
    private int CustomerID;
    private char Pickup;
    private char drop;
    private int pickupTime;
    private double Amount;
    private int dropTime;
    public trip(char pickup, char drop, int pickupTime, double amount,int dropTime) {
        BookingID = i;
        CustomerID = i;
        i++;
        Pickup = pickup;
        this.drop = drop;
        this.pickupTime = pickupTime;
        Amount = amount;
        this.dropTime=dropTime;
    }
    public int getBookingID() {
        return BookingID;
    }
    public int getCustomerID() {
        return CustomerID;
    }
    public char getPickup() {
        return Pickup;
    }
    public char getDrop() {
        return drop;
    }
    public int getPickupTime() {
        return pickupTime;
    }
    public double getAmount() {
        return Amount;
    }
    public int getDropTime() {
        return dropTime;
    }
    
    
}
