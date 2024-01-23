import java.util.*;
import java.util.function.Function;

public class ComprehensiveDS {
    public static void main(String[] args) {
        System.out.println("Hello data structures");
        learnList();
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

        // Sorting
        Collections.sort(arrayList); // Default Ascending order
        arrayList.sort(Integer::compareTo); // another way

        arrayList.sort((Integer a, Integer b) -> {
            return b.compareTo(a);
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
}
