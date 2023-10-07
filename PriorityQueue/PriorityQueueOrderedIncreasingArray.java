import java.util.Arrays;

public class PriorityQueueOrderedIncreasingArray<T> implements PriorityQueue {
    private T[] array; // TODO: extend so that it can accept any value
    private int size;

    public PriorityQueueOrderedIncreasingArray(int capacity) {
        this.size = 0;
        this.array = new T[capacity];
    }

    /*
    * We maintain ordering all the time
    */
    public void add(Object element) {
        // Resize the array if it is full
        if (this.size == this.array.length) {
            this.array = Arrays.copyOf(array, array.length * 2);
        }
        // after expanding the array, add the new element in the end and sort
        this.array[this.size] = element;
        this.size += 1;
        performInsertionSort();
    }

    public void remove(Object element) {
        if (this.size == 0) {
            throw new IllegalStateException("Priority Queue is empty");
        }
        // search the element to be deleted
        int index = searchElement(element);
        if (index == -1) {
            throw new RuntimeException("Element not found");
        }
        // move the element to the end
        this.array[size + 1] = this.array[index];
        moveElements(index);
        this.size -= 1;
    }
    
    public boolean contains(Object element) {
        if (searchElement(element) == -1)
            return false;
        return true;
    }

    public Object peek() {
        if (this.size == 0)
            throw new IllegalStateException("Priority Queue is empty");
        return this.array[0];
    }

    public Object poll() {
        if (this.size == 0) 
            throw new IllegalStateException("Empty Priority Queue");
        Object firstElement = this.array[0];
        moveElements(0);
        this.size -= 1;

        return firstElement;
    }

    public void display() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.array[i] + " ");
        }
    }

    public int size() {
        return this.size;
    }

    private void performInsertionSort() {
        if (this.size == 1) 
            return;
        int current = size - 1;
        int previous = size - 2;

        while(this.array[previous].compareTo(this.array[current]) > 1) {
            // swap the values
            Object temp = this.array[previous];
            this.array[previous] = this.array[current];
            this.array[current] = temp;
            previous -= 1;
            current -= 1;
            // check if we are within array limits
            if (previous == -1)
                return;
        }
    }

    private int searchElement(Object element) {
        int start = 0;
        int end = this.size - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (this.array[mid].equals() == element) {
                return mid;
            }
            else if (this.array[mid] > element) {
                end = mid - 1;
            } 
            else {
                start = mid + 1;
            }
        }
        return -1; // element not found
    }

    // move elements forward one by one
    private void moveElements(int index) {
        int currentIterator = index;
        while (currentIterator < this.size - 1) {
            this.array[currentIterator] = this.array[currentIterator + 1];
            currentIterator += 1;
        }
    }

}