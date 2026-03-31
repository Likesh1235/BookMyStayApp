import java.util.*;

public class HotelBookingAPP {
    private HashMap<String, Integer> inventory;
    private HashMap<String, String> activeBookings;
    private Stack<String> rollbackStack;

    public HotelBookingAPP() {
        inventory = new HashMap<>();
        activeBookings = new HashMap<>();
        rollbackStack = new Stack<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public void confirmBooking(String roomId, String roomType) {
        if (inventory.containsKey(roomType) && inventory.get(roomType) > 0) {
            inventory.put(roomType, inventory.get(roomType) - 1);
            activeBookings.put(roomId, roomType);
            System.out.println("Booking confirmed: " + roomId);
        }
    }

    public void cancelBooking(String roomId) {
        if (!activeBookings.containsKey(roomId)) {
            System.out.println("Cancellation failed: Invalid Room ID " + roomId);
            return;
        }
        String roomType = activeBookings.get(roomId);
        rollbackStack.push(roomId);
        activeBookings.remove(roomId);
        inventory.put(roomType, inventory.get(roomType) + 1);
        System.out.println("Booking cancelled: " + roomId);
    }

    public void showRollbackStack() {
        System.out.println("Rollback Stack: " + rollbackStack);
    }

    public static void main(String[] args) {
        HotelBookingAPP app = new HotelBookingAPP();
        app.addRoomType("Single", 2);
        app.confirmBooking("Single-1", "Single");
        app.confirmBooking("Single-2", "Single");
        app.cancelBooking("Single-2");
        app.cancelBooking("Single-3");
        app.showRollbackStack();
    }
}
