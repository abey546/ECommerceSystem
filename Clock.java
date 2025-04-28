// Clock.java
import java.text.SimpleDateFormat;
import java.util.Date;

// Clock class to display the current time and date
public class Clock {
    private volatile boolean running = true; // To control the running state safely between threads

    // Method to continuously update and print the current time
    public void startClock() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
        while (running) {
            Date currentDate = new Date();
            System.out.println(formatter.format(currentDate));
            try {
                Thread.sleep(1000); // Sleep for 1 second before updating time again
            } catch (InterruptedException e) {
                System.err.println("Clock thread interrupted: " + e.getMessage());
                Thread.currentThread().interrupt(); // Restore interrupted status
            }
        }
    }

    // Method to stop the clock
    public void stopClock() {
        running = false;
    }
}
