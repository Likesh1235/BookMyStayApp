import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);

public class BookMyStayApp {

class Reservation {
    String guestName;
    String roomId;

    public Reservation(String guestName, String roomId) {
        this.guestName = guestName;
        this.roomId = roomId;
        this.roomType = roomType;
    }


class SingleRoom extends Room {
    public void displayRoomDetails() {
        System.out.println("Beds:1");
        System.out.println("Size:250 sqft");
        System.out.println("Price per night:1500.0");
    }
}

class DoubleRoom extends Room {
    public void displayRoomDetails() {
        System.out.println("Beds:2");
        System.out.println("Size:400 sqft");
        System.out.println("Price per night:2500.0");
    }
}

class SuiteRoom extends Room {
    public void displayRoomDetails() {
        System.out.println("Beds:3");
        System.out.println("Size:750 sqft");
        System.out.println("Price per night:5000.0");

    void display() {
        System.out.println("ID: " + reservationId +
                " | Guest: " + guestName +
                " | Room: " + roomType);
    }
}

public class HotelBookingAPP {
    private HashMap<String, Integer> inventory;

    public HotelBookingAPP() {
        inventory = new HashMap<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public void validateBooking(String roomType) throws InvalidBookingException {
        if (!inventory.containsKey(roomType)) {
            throw new InvalidBookingException("Invalid room type: " + roomType);
        }
        if (inventory.get(roomType) <= 0) {
            throw new InvalidBookingException("No rooms available for: " + roomType);
    List<Reservation> getAllReservations() {
        return history;

    void addService(String reservationId, Service service) {
        serviceMap.putIfAbsent(reservationId, new ArrayList<>());
        serviceMap.get(reservationId).add(service);


    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
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
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();

    }
}

class RoomInventory {

    static class Service {
        private String serviceName;
        private double cost;

        public Service(String serviceName, double cost) {
            this.serviceName = serviceName;
            this.cost = cost;
        }

        public String getServiceName() {
            return serviceName;
        }

        public double getCost() {
            return cost;
        }
    }
}


    static class AddOnServiceManager {
        private Map<String, List<Service>> servicesByReservation;

        public AddOnServiceManager() {
            servicesByReservation = new HashMap<>();

class BookingReportService {

    void showAllBookings(List<Reservation> history) {
        System.out.println("Booking History:");

        for (Reservation r : history) {
            r.display();

        }
    }


        public void addService(String reservationId, Service service) {
            if (!servicesByReservation.containsKey(reservationId)) {
                servicesByReservation.put(reservationId, new ArrayList<>());
            }
            servicesByReservation.get(reservationId).add(service);
        }

        public double calculateTotalServiceCost(String reservationId) {
            double total = 0;
            if (servicesByReservation.containsKey(reservationId)) {
                for (Service s : servicesByReservation.get(reservationId)) {
                    total += s.getCost();
                }
            }

    void showSummary(List<Reservation> history) {
        Map<String, Integer> countMap = new HashMap<>();

        for (Reservation r : history) {
            countMap.put(r.roomType,
                    countMap.getOrDefault(r.roomType, 0) + 1);
        }
    }

    public void bookRoom(String guestName, String roomType) {
        try {
            validateBooking(roomType);
            inventory.put(roomType, inventory.get(roomType) - 1);
            System.out.println("Booking successful for " + guestName + " (" + roomType + ")");
        } catch (InvalidBookingException e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HotelBookingAPP app = new HotelBookingAPP();
        app.addRoomType("Single", 1);
        app.addRoomType("Double", 0);
        app.bookRoom("Abhi", "Single");
        app.bookRoom("Subha", "Double");
        app.bookRoom("Vanmathi", "Suite");
    public static void main(String[] args) {
        AddOnServiceManager manager = new AddOnServiceManager();

        String reservationId = "Single-1";
class BookMyStayApp {
    public static void main(String[] args) {

        String appName = "Book My Stay App";
        String version = "Hotel Booking System v8.0";

        System.out.println("=====================================");
        System.out.println("        " + appName);
        System.out.println("=====================================");
        System.out.println("Version: " + version);
        System.out.println("-------------------------------------");

        BookingHistory history = new BookingHistory();

        history.addReservation(new Reservation("R101", "Alice", "Single Room"));
        history.addReservation(new Reservation("R102", "Bob", "Double Room"));
        history.addReservation(new Reservation("R103", "Charlie", "Single Room"));
        history.addReservation(new Reservation("R104", "David", "Suite Room"));

        BookingReportService report = new BookingReportService();

        report.showAllBookings(history.getAllReservations());

        System.out.println("-------------------------------------");

        report.showSummary(history.getAllReservations());

        Service s1 = new Service("Breakfast", 500);
        Service s2 = new Service("Spa", 700);
        Service s3 = new Service("Airport Pickup", 300);

        manager.addService(reservationId, s1);
        manager.addService(reservationId, s2);
        manager.addService(reservationId, s3);

        double total = manager.calculateTotalServiceCost(reservationId);

        System.out.println("Add-on Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println("Total Add-On Cost: " + total);
    }
}
