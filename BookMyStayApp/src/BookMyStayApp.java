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
}

class Service {
    String serviceName;
    double cost;

    Service(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }
}

class AddOnServiceManager {
    private Map<String, List<Service>> serviceMap = new HashMap<>();

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

    void displayServices(String reservationId) {
        List<Service> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        double total = 0;
        System.out.println("Services for Reservation " + reservationId + ":");

        for (Service s : services) {
            System.out.println("- " + s.serviceName + " : $" + s.cost);
            total += s.cost;
        }

        System.out.println("Total Add-On Cost: $" + total);
    }
}

class Main {
    public static void main(String[] args) {

        String appName = "Book My Stay App";
        String version = "Hotel Booking System v7.0";

        System.out.println("=====================================");
        System.out.println("        " + appName);
        System.out.println("=====================================");
        System.out.println("Version: " + version);
        System.out.println("-------------------------------------");

        Reservation r1 = new Reservation("R101", "Alice", "Single Room");

        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService("R101", new Service("Breakfast", 20));
        manager.addService("R101", new Service("Airport Pickup", 50));
        manager.addService("R101", new Service("Extra Bed", 30));

        manager.displayServices("R101");

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