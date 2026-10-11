
public class ConcurrencyCounters {

    // Thread 1 counts upward from 0 to 20
    public static void countUp() {
        for (int number = 0; number <= 20; number++) {
            System.out.println("Thread 1 counting up: " + number);
        }
    }

    // Thread 2 counts downward from 20 to 0
    public static void countDown() {
        for (int number = 20; number >= 0; number--) {
            System.out.println("Thread 2 counting down: " + number);
        }
    }

    public static void main(String[] args) {

        // Create the two threads
        Thread firstThread = new Thread(
                ConcurrencyCounters::countUp);

        Thread secondThread = new Thread(
                ConcurrencyCounters::countDown);

        try {
            // Start the first thread
            firstThread.start();

            // Wait until the first thread finishes
            firstThread.join();

            // Start the second thread
            secondThread.start();

            // Wait until the second thread finishes
            secondThread.join();

            System.out.println(
                    "Both threads have finished.");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println(
                    "Counting was interrupted.");
        }
    }
}
