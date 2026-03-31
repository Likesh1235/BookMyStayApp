import java.util.*;

class Reservation {
    String guestName;
    String roomId;

    public Reservation(String guestName, String roomId) {
        this.guestName = guestName;
        this.roomId = roomId;
    }
}

public class HotelBookingAPP {
    private List<Reservation> bookingHistory;

    public HotelBookingAPP() {
        bookingHistory = new ArrayList<>();
    }

    public void addBooking(String guestName, String roomId) {
        bookingHistory.add(new Reservation(guestName, roomId));
    }

    public void displayHistory() {
        System.out.println("Booking History");
        for (Reservation r : bookingHistory) {
            System.out.println("Guest: " + r.guestName + ", Room ID: " + r.roomId);
        }
    }

    public void generateReport() {
        System.out.println("\nBooking Report");
        System.out.println("Total Bookings: " + bookingHistory.size());
    }

    public static void main(String[] args) {
        HotelBookingAPP app = new HotelBookingAPP();
        app.addBooking("Abhi", "Single-1");
        app.addBooking("Subha", "Single-2");
        app.addBooking("Vanmathi", "Suite-1");
        app.displayHistory();
        app.generateReport();
    }
}
