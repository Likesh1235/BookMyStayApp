import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
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
    }
}
