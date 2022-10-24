import java.util.Scanner;

public class application {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ticketBooking.createTaxi();
        while (true) {
            System.out.println("1.Book Taxi  2. Print Details");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    bookTaxi();
                    break;
                case 2:
                    printDetails();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void bookTaxi() {
        System.out.println("Pickup point");
        char pickup = scan.next().charAt(0);
        if (pickup < 'A' || pickup > 'F'){
            System.out.println("Invalid Pickup Point");
            return;
        }
        System.out.println("Drop point");
        char drop = scan.next().charAt(0);
        if (drop < 'A' || drop > 'F'){
            System.out.println("Invalid Drop Point");
            return;
        }
        System.out.println("Pickup Time");
        int pickupTime = scan.nextInt();
        if(pickupTime<0 || pickupTime >24){
            System.out.println("Invalid Time");
            return;
        }
        ticketBooking.bookTaxi(pickup, drop, pickupTime);
        ticketBooking.printStatus();
    }

    public static void printDetails() {
        ticketBooking.printDetails();
    }
}
