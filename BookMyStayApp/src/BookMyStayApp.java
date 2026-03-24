import java.util.*;

class Reservation {
    String reservationId;
    String guestName;
    String roomType;

    Reservation(String reservationId, String guestName, String roomType) {
        this.reservationId = reservationId;
        this.guestName = guestName;
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

class BookingHistory {
    private List<Reservation> history = new ArrayList<>();

    void addReservation(Reservation r) {
        history.add(r);
    }


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

class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();

    }
}

class RoomInventory {

    private Map<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    public int getAvailable(String type) {
        return availability.get(type);
    }

    public void decrement(String type) {
        availability.put(type, availability.get(type) - 1);

    }
}

class BookingReportService {

    void showAllBookings(List<Reservation> history) {
        System.out.println("Booking History:");

        for (Reservation r : history) {
            r.display();
        }
    }

    void showSummary(List<Reservation> history) {
        Map<String, Integer> countMap = new HashMap<>();

        for (Reservation r : history) {
            countMap.put(r.roomType,
                    countMap.getOrDefault(r.roomType, 0) + 1);
        }

        System.out.println("Booking Summary:");
        for (String type : countMap.keySet()) {
            System.out.println(type + " : " + countMap.get(type));
        }
    }
}

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

        System.out.println("-------------------------------------");
        System.out.println("System execution completed.");

class RoomAllocationService {

    private Set<String> allocatedRoomIds;
    private Map<String, Set<String>> assignedRoomsByType;

    public RoomAllocationService() {
        allocatedRoomIds = new HashSet<>();
        assignedRoomsByType = new HashMap<>();
    }

    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String type = reservation.getRoomType();

        if (inventory.getAvailable(type) <= 0) {
            System.out.println("No rooms available for " + reservation.getGuestName());
            return;
        }

        String roomId = generateRoomId(type);

        allocatedRoomIds.add(roomId);

        assignedRoomsByType.putIfAbsent(type, new HashSet<>());
        assignedRoomsByType.get(type).add(roomId);

        inventory.decrement(type);

        System.out.println("Booking confirmed for Guest: " + reservation.getGuestName() + ", Room ID: " + roomId);
    }

    private String generateRoomId(String roomType) {

        int number = 1;

        if (assignedRoomsByType.containsKey(roomType)) {
            number = assignedRoomsByType.get(roomType).size() + 1;
        }

        return roomType + "-" + number;
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        RoomAllocationService allocator = new RoomAllocationService();

        queue.addRequest(new Reservation("Abhi", "Single"));
        queue.addRequest(new Reservation("Subha", "Single"));
        queue.addRequest(new Reservation("Vanmathi", "Suite"));

        System.out.println("Room Allocation Processing");

        while (queue.hasPendingRequests()) {
            Reservation r = queue.getNextRequest();
            allocator.allocateRoom(r, inventory);
        }
    }
}