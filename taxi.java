import java.util.ArrayList;

public class taxi {
    static int i=1;
    private int taxiID;
    private double totalEarning;
    private char currentSpot;
    private int Freetime;
    ArrayList<trip> trips;
    public taxi() {
        this.taxiID = i;
        i++;
        this.totalEarning = 0;
        this.currentSpot = 'A';
        Freetime = 6;
        trips = new ArrayList<trip>();
    }
    public int getTaxiID() {
        return taxiID;
    }
    public double getTotalEarning() {
        return totalEarning;
    }
    public char getCurrentSpot() {
        return currentSpot;
    }
    public int getFreetime() {
        return Freetime;
    }
    public void setTotalEarning(double totalEarning) {
        this.totalEarning += totalEarning;
    }
    public void setCurrentSpot(char currentSpot) {
        this.currentSpot = currentSpot;
    }
    public void setFreetime(int freetime) {
        Freetime = freetime;
    }
    public void setTrips(char pickup, char drop, int pickupTime, double amount,int dropTime){
        trips.add(new trip(pickup, drop, pickupTime, amount,dropTime));
    }
    public void printDetails(){
        for(trip t: trips){
            String formattedString = String.format("%02d", t.getPickupTime());
            String formattedString1 = String.format("%02d", t.getDropTime());
            System.out.println("    "+t.getBookingID()+"           "+t.getCustomerID()+"        "+t.getPickup()
                                +"    "+t.getDrop()+"       "+formattedString+"         "+formattedString1+"     "+t.getAmount()+"   ");
        }
    }
}
