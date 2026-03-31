import java.io.*;
import java.util.*;

class Reservation implements Serializable {
    String guestName;
    String roomId;

    public Reservation(String guestName, String roomId) {
        this.guestName = guestName;
        this.roomId = roomId;
    }
}

public class BookMyStayApp implements Serializable {
    private HashMap<String, Integer> inventory;
    private List<Reservation> bookingHistory;
    private static final String FILE_NAME = "hotel_data.ser";

    public BookMyStayApp() {
        inventory = new HashMap<>();
        bookingHistory = new ArrayList<>();
    }

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public void addBooking(String guestName, String roomId) {
        bookingHistory.add(new Reservation(guestName, roomId));
    }

    public void saveData() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            oos.writeObject(this);
            oos.close();
            System.out.println("Data saved successfully.");
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }

    public static BookMyStayApp loadData() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
            BookMyStayApp app = (BookMyStayApp) ois.readObject();
            ois.close();
            System.out.println("Data loaded successfully.");
            return app;
        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
            return new BookMyStayApp();
        }
    }

    public void displayData() {
        System.out.println("\nInventory:");
        for (String type : inventory.keySet()) {
            System.out.println(type + " -> " + inventory.get(type));
        }

        System.out.println("\nBooking History:");
        for (Reservation r : bookingHistory) {
            System.out.println("Guest: " + r.guestName + ", Room ID: " + r.roomId);
        }
    }

    public static void main(String[] args) {
        BookMyStayApp app = BookMyStayApp.loadData();
        app.addRoomType("Single", 2);
        app.addBooking("Abhi", "Single-1");
        app.displayData();
        app.saveData();
    }
}
