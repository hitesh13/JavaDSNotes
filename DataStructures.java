import java.util.*;

public class DataStructures {
    public static void main(String []args) {
        System.out.println("Hello world");
        Stack<Integer> stack = new Stack<Integer>();
        
        List<Integer> arrayList = new ArrayList<Integer>();
        for(int i = 0;i<10;i++) {
            arrayList.add(i*i);
        }

        // while(!arrayList.isEmpty()) {
        //     System.out.println(arrayList.remove(0));
        // }
        // System.out.println(arrayList);

        mapDSNotes();
    }

    private static void setDSNotes() {
        // set creation
        Set<String> set = new HashSet<String>();
        // set addtion of elements
        set.add("Helo");
        set.add("Hell");
        set.add("world");
        set.add("Boys");
        set.add("Hell");

        // set removal of elements
        set.remove("world");

        // set iteration
        for(String s: set) {
            System.out.println("Set has "+s);
        }

        // Set interface is implemented by the following classes
        
        // order is not maintained
        Set<Integer> hset = new HashSet<Integer>();
        ///Set<Integer> enumset = EnumSet.of(//enums)

        // order is maintained as the elements were inserted
        // uses doubly linked list to store the elements
        Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();

        /* elements are stored in a sorted order
           uses tree as collection of elements
        */
        Set<Integer> treeSet = new TreeSet<Integer>();

        // addtion, removal, contains methods
        treeSet.add(12); // adds 12 to the set
        treeSet.add(13);

        treeSet.remove(12); // removes 12 from the set

        treeSet.contains(13); // returns true if set contains 13 else false

        treeSet.retainAll(linkedHashSet); // just retain all the elements in the any collection from treeSet and return them
        
        // iteration using iteration() method

        Iterator<Integer> hasetIt = treeSet.iterator();
        Iterator<Integer> lhsIt = treeSet.iterator();
        Iterator<Integer> tsIt = treeSet.iterator();

        while(tsIt.hasNext()) {
            System.out.println(tsIt.next());
        }
    }

    private static void listDSNotes() {
        /*
            There are so many array data stuctures in Java
            like ArrayList, Vector, LinkedList which all implements List interface
        */

        // ArrayList
        List<Integer> al = new ArrayList<Integer>();
        // addition, deletion, remove, set(change)
        al.add(12); // added at last time: O(1)
        al.add(14);

        al.set(1, 42);
        al.add(1, 13); // add element after index : i // time: O(N)

        Integer array[] = {12,34,212,4,324,12,43,1};
        al.addAll(new ArrayList<Integer>(Arrays.asList(array)));

        // removal by value only removes first occurance
        al.remove(Integer.valueOf(12)); // Time: O(N)

        // remvoal by index
        al.remove(0);

        al.sort((Integer a,Integer b) -> {
            return Integer.compare(b, a);
        });
        // the closure function is implemented as comparator

        /*
            SAME IS IMPLEMENTED FOR VECTOR
            BUT THERE IS A SLIGHT DIFFERENECE BETWEEN VECTOR AND ARRAYLIST
         */

        /*
            STACK IS EXTENSION OF VECTOR
            ADDITIONAL METHODS LIKE push(), pop(), peek() STANDARD METHODS ARE ADDED
        */

        // LinkedList initialization
        /*  Almost all the methods of ArrayList works here too
            LinkedList implements List<T> and als Deque<T> where as
            ArratList only implements List<T>, so LinkedList can also
            be used as Deque.
            
            If we want to store large data and access quickely we can use ArrayList
            else we want to keep adding and deleting objects we can use LinkedList
        */
        List<Integer> ll = new LinkedList<Integer>();
        Deque<Integer> dq = new LinkedList<Integer>();

        // lot of usefull methods please go through them

        System.out.println(al);
    }

    private static void queueDSNotes() {
        /* For Deques we can use classes which implements Deque<T>
            Which are LinkedList and ArrayDeque
            Main difference is
            LinkedList -> implemented using DoubleyLinkedList
            ArrayQueue -> implemented using Arrays
        */

        // LinkedList
        Deque<Integer> lldq = new LinkedList<Integer>();

        // Addition, Deletion, contains
        lldq.addFirst(12);
        lldq.addFirst(34);
        lldq.addLast(21);
        lldq.addLast(43);

        lldq.peekFirst(); // returns first element without removal
        lldq.getFirst(); // returns first element without removal but throws exception if queue is empty
        lldq.pollFirst(); // returns first element by removal
        // Iteration of queue
        Iterator<Integer> it = lldq.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // SAME WAY OF IMPLEMENTATION FOR ArrayDeque
        Deque<Integer> ardq = new ArrayDeque<Integer>();

        // IMPLEMENTATION OF PRIORITY_QUEUE
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((Integer a, Integer b) -> {
            return b.compareTo(a);
        });
        pq.add(12); // inserts element into the Priority queue
        pq.add(12);
        pq.add(34);
        pq.add(32);
        pq.add(90);
        pq.poll(); // Retrives and removes the head;
        pq.peek(); // Retrives top element
        pq.remove(12); // only removes one element
        System.out.println(pq);
    }

    public static void mapDSNotes() {
        /*
            There are various implementation of Map<T> interface
            Differences are based on data structure used in implementation 
            or concurrency supporting

            Most used ones are HashMap and TreeMap
            HashMap: Random order
            TreeMap: Sorted order
        */

        AbstractMap<Integer, String> ahmap = new HashMap<Integer, String>();

        // adding key value pairs
        ahmap.put(12, "Hello");
        ahmap.put(43, "World");
        ahmap.put(32, "Fellas");
        ahmap.put(43, "Earth"); // if key is already present value will be replaced

        // access values
        ahmap.get(12);

        // replacing keys
        ahmap.replace(12, "Greetings");

        // contains keys
        ahmap.containsKey(12);
        ahmap.containsValue("Earth");

        // remove key value pair
        ahmap.remove(32);
        ahmap.remove(12, "Hello"); // only removes if value matches specified value

        // size
        System.out.println("size "+ahmap.size());
        
        // isEmpty()
        System.out.println("is empty "+ahmap.isEmpty());
        System.out.println(ahmap);

        // Iterating through key values
        // Method 1
        System.out.println("#Method 1");
        for(Map.Entry entry: ahmap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }

        // Method 2
        System.out.println("#Method 2");
        Iterator<Integer> it = ahmap.keySet().iterator();
        while(it.hasNext()) {
            Integer key = it.next();
            System.out.println("Key: " + key + " value: " + ahmap.get(key));
        }

        // TreeMap

        AbstractMap<Integer, String> atmap = new TreeMap<Integer, String>(
            (Integer a, Integer b) -> {
                return a.compareTo(b);
            }
        );

        atmap.put(18, "Virat");
        atmap.put(25, "Dhawan");
        atmap.put(7, "Dhoni");
        System.out.println("Treemap traversal");
        for(Map.Entry entry: atmap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " value: " + entry.getValue());
        }

        ArrayList<Integer> graph[] = new ArrayList<>[7];

    }
}