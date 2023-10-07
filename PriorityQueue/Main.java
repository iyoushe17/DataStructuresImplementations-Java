public class Main {
    public static void main(String[] args) {
        PriorityQueueOrderedArray pq = new PriorityQueueOrderedArray(5);
        
        pq.insert(2);
        pq.insert(3);
        pq.insert(1);
        pq.insert(0);
        pq.insert(7);
        pq.insert(18);
        pq.display();
        System.out.println();

        pq.delete(7);
        pq.display();
        System.out.println();

        // pq.delete(12);
        // pq.display();
        // System.out.println();

        pq.poll();
        pq.display();
        System.out.println();

    }
}
