import java.util.HashMap;
import java.util.Map;

class RoomInventory {
    private final Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    private void initializeInventory() {
        roomAvailability.put("Single", 5);
        roomAvailability.put("Double", 3);
        roomAvailability.put("Suite", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

class SingleRoom {
    public void displayRoomDetails() {
        System.out.println("Beds: 1");
        System.out.println("Size: 250 sqft");
        System.out.println("Price per night:1500.0");
    }
}

class DoubleRoom {
    public void displayRoomDetails() {
        System.out.println("Beds: 2");
        System.out.println("Size: 400 sqft");
        System.out.println("Price per night:2500.0");
    }
}

class SuiteRoom {
    public void displayRoomDetails() {
        System.out.println("Beds:3");
        System.out.println("Size: 750 sqft");
        System.out.println("Price per night:5000.0");
    }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        RoomInventory inventory = new RoomInventory();
        SingleRoom singleRoom = new SingleRoom();
        DoubleRoom doubleRoom = new DoubleRoom();
        SuiteRoom suiteRoom = new SuiteRoom();

        System.out.println("Single Room:");
        singleRoom.displayRoomDetails();
        System.out.println("Available : " + inventory.getRoomAvailability().get("Single"));
        System.out.println();

        System.out.println("Double Room:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available : " + inventory.getRoomAvailability().get("Double"));
        System.out.println();

        System.out.println("Suite Room:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available : " + inventory.getRoomAvailability().get("Suite"));
    }
}