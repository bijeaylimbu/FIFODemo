import java.util.Scanner;
/**
 * Main class for demonstrating a FIFO (First-In-First-Out) with a fixed capacity.
 */
public class FIFOQueueDemo {
    private static final int CAPACITY = 5; // Maximum capacity of the queue
    private static final FixedCapacityQueue<Integer> fifoQueue = new FixedCapacityQueue<>(CAPACITY);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        processInput(); // Delegate user interaction
    }

    /**
     * processes user input until the exit condition is inputted.
     */
    private static void processInput() {
        while (true) {
            int number = getNumberFromUser(); // Get a number from the user
            if (number == -1) { // Exit condition
                System.out.println("Exiting...");
                break;
            }
            addToQueue(number); // Add the number to the queue
        }
        scanner.close(); // Close scanner resource
    }

    /**
     * Prompts the user for a number and validates the input.
     *
     * @return A valid integer entered by the user.
     */
    private static int getNumberFromUser() {
        while (true) {
            System.out.print("Enter a number to add (-1 to exit): ");
            try {
                return scanner.nextInt(); // Attempt to read an integer
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    /**
     * Adds a number to the queue, removing the oldest element if the queue is full.
     *
     * @param number The number to add to the queue.
     */
    private static void addToQueue(int number) {
        if (fifoQueue.add(number)) { // Add the number to the queue
            System.out.println(number + " added to the list.");
        }
        displayQueue(); // Display the current queue
    }

    /**
     * Displays the current state of the queue.
     */
    private static void displayQueue() {
        System.out.println("Current Queue: " + fifoQueue);
    }
}
