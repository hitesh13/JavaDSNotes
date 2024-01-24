import java.util.*;

public class ComprehensiveDS {
    public static void main(String[] args) {
        System.out.println("Hello data structures");
        learnList();
        learnQueue();
    }

    public static void learnList() {

        /***
         * There are so many array data structures in Java
         * like ArrayList, Vector, LinkedList which all implements List interface
         * Find the diff here {@link https://medium.com/zero-equals-false/arraylist-vs-linkedlist-vs-vector-22e1721a66b0}
         *
         * But we mainly focus on arrayList for coding questions
         */
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();

        // Addition and removal of elements
        arrayList.add(1); // O(1) addition at last position
        arrayList.add(0, 2); // O(N) addition at position
        arrayList.remove(1); // O(N) removal at index 1
        int arrayListSize = arrayList.size();
        boolean empty = arrayList.isEmpty();

        // Sorting
        Collections.sort(arrayList); // Default Ascending order
        arrayList.sort(Integer::compareTo); // another way

        arrayList.sort((Integer a, Integer b) -> {
            return b.compareTo(a); // (b < a) ? -1 : ((b == a) ? 0 : 1)
        }); // reverse order
        arrayList.sort(Comparator.reverseOrder()); // short form for reverse order
    }

    public void ArrayAndListConversions() {

        // int[] to ArrayList or List conversion
        Integer[] x = new Integer[] {1, 2, 3, 4, 5};
        List<Integer> listX = Arrays.asList(x);

        // ArrayList to int[] conversions
        int[] arrayX = listX.stream()
                .filter(Objects::nonNull) // filtering out null values
                .mapToInt(Integer::intValue).toArray();
    }

    public static void learnQueue() {
        /**
         * There are 2 ways of implementing queues using LinkedList and ArrayQueue
         * LinkedList uses DoublyLinkedList
         * ArrayQueue uses Arrays
         */

        Deque<Integer> arrayDeque = new ArrayDeque<>();
        Deque<Integer> linkedListQueue = new ArrayDeque<>();

        linkedListQueue.addFirst(1);
        linkedListQueue.addLast(2);
        linkedListQueue.addFirst(3);
        linkedListQueue.addLast(4);

        linkedListQueue.removeFirst(); // returns nothing just removes the element
        linkedListQueue.removeLast();

        int size = linkedListQueue.size();
        boolean empty = linkedListQueue.isEmpty();

        // 1. peeks and polls

        Integer first = linkedListQueue.peekFirst(); // just gets the element
        Integer last = linkedListQueue.peekLast();

        /**
         * Difference between remove and poll is
         * remove throws empty if queue is empty
         * poll returns null
         */
        first = linkedListQueue.pollFirst(); // removes and gets the element
        last = linkedListQueue.pollLast(); // removes and gets the element

        // 2. Iterations

        // using iterator
        Iterator<Integer> it = linkedListQueue.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // using enhanced for loop
        for(Integer value: linkedListQueue) {
            System.out.println(value);
        }

        /**
         * Priority queue is type of queue where polling of elements based on priority
         * MinHeap and MaxHeap can be implemented using priority queue
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // default min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Integer::compareTo); // default min heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b.compareTo(a)); // default min heap>
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder()); // another way

        // 1. add, peak and poll
        minHeap.add(1);
        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(5);
        minHeap.add(3);

        int top = minHeap.peek(); // gets top element
        top = minHeap.poll(); // removes and gets top element

        // 2. Iterations
        for(Integer entry: minHeap) {
            System.out.println(entry);
        }
    }
}
