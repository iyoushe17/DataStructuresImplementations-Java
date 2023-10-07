public interface PriorityQueue {
    void add(Object element);
    
    // delete a particular element
    void remove(Object element);

    boolean contains(Object element);

    Object peek();

    // removes and returns the first element
    Object poll();
    
    void display();

    int size();
}
