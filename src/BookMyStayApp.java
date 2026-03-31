import java.util.*;

class Reservation {
    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }
}

public class BookMyStayApp {
    private HashMap<String, Integer> inventory = new HashMap<>();
    private Queue<Reservation> bookingQueue = new LinkedList<>();

    public void addRoomType(String type, int count) {
        inventory.put(type, count);
    }

    public synchronized void addRequest(Reservation r) {
        bookingQueue.add(r);
    }

    public synchronized void processBooking() {
        if (bookingQueue.isEmpty()) return;
        Reservation r = bookingQueue.poll();
        int available = inventory.getOrDefault(r.roomType, 0);
        if (available > 0) {
            inventory.put(r.roomType, available - 1);
            System.out.println(Thread.currentThread().getName() +
                    " SUCCESS: " + r.guestName + " booked " + r.roomType);
        } else {
            System.out.println(Thread.currentThread().getName() +
                    " FAILED: " + r.guestName + " (No rooms)");
        }
    }

    class BookingThread extends Thread {
        public void run() {
            while (true) {
                synchronized (BookMyStayApp.this) {
                    if (bookingQueue.isEmpty()) break;
                }
                processBooking();
            }
        }
    }

    public static void main(String[] args) {
        BookMyStayApp app = new BookMyStayApp();
        app.addRoomType("Single", 2);
        app.addRequest(new Reservation("Abhi", "Single"));
        app.addRequest(new Reservation("Subha", "Single"));
        app.addRequest(new Reservation("Vanmathi", "Single"));
        Thread t1 = app.new BookingThread();
        Thread t2 = app.new BookingThread();
        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t1.start();
        t2.start();
    }
}
