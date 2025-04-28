// ClockApp.java
public class ClockApp {
    public static void main(String[] args) {
        Clock clock = new Clock();

        // Thread for updating and printing the clock
        Thread clockThread = new Thread(new Runnable() {
            @Override
            public void run() {
                clock.startClock();
            }
        });

        // Background thread (can be used for future enhancements like alarms, settings, etc.)
        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(5000); // Background thread does some low-priority tasks every 5 seconds
                    } catch (InterruptedException e) {
                        System.err.println("Background thread interrupted: " + e.getMessage());
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        });

        // Setting thread priorities
        clockThread.setPriority(Thread.MAX_PRIORITY); // High priority
        backgroundThread.setPriority(Thread.MIN_PRIORITY); // Low priority

        // Start both threads
        clockThread.start();
        backgroundThread.start();
    }
}
