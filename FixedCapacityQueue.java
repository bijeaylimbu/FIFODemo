import java.util.LinkedList;
import java.util.Queue;

/**
 * A generic queue that maintains a fixed capacity.
 * When the capacity is fulled, the first item is removed to make space for a new one.
 *
 * @param <T> The type of elements held in this queue.
 */
public class FixedCapacityQueue<T> {
    private final int capacity;  // The maximum number of items the queue can hold
    private final Queue<T> queue; // The internal queue to store the elements

    /**
     * Constructs a FixedCapacityQueue with the specified capacity.
     *
     * @param capacity The maximum number of items the queue can fill.
     * @throws IllegalArgumentException if the capacity is less than or equal to zero.
     */
    public FixedCapacityQueue(int capacity) {
        // Validate capacity to ensure it's greater than zero
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero.");
        }
        this.capacity = capacity;
        this.queue = new LinkedList<>(); // Initialize the internal queue using LinkedList
    }

    /**
     * Adds an item to the list. If the list is full, the first item is removed to make space.
     *
     * @param item The item to be added to the queue.
     * @return true if the item was added successfully, false otherwise.
     */
    public boolean add(T item) {
        // If the list is full, remove the oldest item
        if (queue.size() == capacity) {
            queue.poll(); // Removes the first (oldest) item in the queue
        }
        // Add the new item to the queue
        queue.add(item);
        return true; // Indicate successful addition
    }

    /**
     * Returns a string representation of the queue, showing all the elements.
     *
     * @return A string representing the current state of the queue.
     */
    @Override
    public String toString() {
        return queue.toString(); // Return the string representation of the internal queue
    }
}
