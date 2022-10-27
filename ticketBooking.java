import java.util.ArrayList;

public class ticketBooking {
    static ArrayList<taxi> taxis = new ArrayList<taxi>();

    public static void createTaxi() {
        taxis.add(new taxi());
        taxis.add(new taxi());
        taxis.add(new taxi());
        taxis.add(new taxi());
    }

    public static int findFreeTaxi(char pickup, int startTime) {
        taxi freeTaxi = null;
        int minDistance = 6;
        double totalEarning = Double.MAX_VALUE;
        for (taxi t : taxis) {
            char currentSpot = t.getCurrentSpot();
            // boolean check = false;
            // if ((currentSpot == pickup) && (startTime >= t.getFreetime())) {
            //     for (taxi x : taxis) {
            //         if ((x.getTaxiID() != t.getTaxiID()) && t.getCurrentSpot() == x.getCurrentSpot()) {
            //             if (t.getTotalEarning() < x.getTotalEarning()) {
            //                 freeTaxi = t;
            //                 check = true;
            //                 break;
            //             }
            //             else{
            //                 freeTaxi = x;
            //                 check = true;
            //                 break;
            //             }
            //         }
            //     }
            //     if (check)
            //         break;

            // }
            System.out.println("Hello World!");
            int diff = Math.abs(currentSpot - pickup);
            if (diff <= minDistance && startTime >= t.getFreetime() && (startTime - t.getFreetime()) >= diff
                    && (totalEarning > t.getTotalEarning())) {
                freeTaxi = t;
                totalEarning = t.getTotalEarning();
                minDistance = diff;
            }

        }
        if (freeTaxi == null) {
            System.out.println("No taxis are free");
            return -1;
        }
        System.out.println("Taxi No : " + freeTaxi.getTaxiID() + " is booked");
        return freeTaxi.getTaxiID();
    }

    public static void bookTaxi(char startPoint, char endPoint, int pickupTime) {
        double distance = 15 * Math.abs(startPoint - endPoint);
        double cost = 100 + ((distance - 5) * 10);
        int freetime = (pickupTime + Math.abs(startPoint - endPoint))%24;
        int index = findFreeTaxi(startPoint, pickupTime) - 1;
        if (index == -2)
            return;
        taxis.get(index).setTrips(startPoint, endPoint, pickupTime, cost, freetime);
        taxis.get(index).setCurrentSpot(endPoint);
        taxis.get(index).setTotalEarning(cost);
        taxis.get(index).setFreetime(freetime);
    }

    public static void printDetails() {
        for (taxi t : taxis) {
            System.out.println("Taxi No: " + t.getTaxiID() + " Total Earnings: " + t.getTotalEarning() +
                    "\nBookingID  CustomerID  From  To  PickupTime  DropTime  Amount");
            t.printDetails();
        }
    }

    public static void printStatus() {
        for (taxi t : taxis) {
            System.out.println("Taxi ID : " + t.getTaxiID() + " Current Spot : " + t.getCurrentSpot()
                    + " Next Freetime : " + t.getFreetime() + " Total Earnings : " + t.getTotalEarning());
        }
    }
}
