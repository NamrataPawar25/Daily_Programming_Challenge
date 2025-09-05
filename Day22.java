import java.util.*;

public class FirstElementToRepeatKTimes {

    public static int firstElementKTimes(int[] arr, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freq.get(num) == k) {
                return num;
            }
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 1, 4, 4, 5, 2, 6, 1, 4};
        System.out.println(firstElementKTimes(arr1, 2)); 

        int[] arr2 = {2, 3, 4, 2, 2, 5, 5};
        System.out.println(firstElementKTimes(arr2, 2)); 

        int[] arr3 = {1, 1, 1, 1};
        System.out.println(firstElementKTimes(arr3, 1));

        int[] arr4 = {10};
        System.out.println(firstElementKTimes(arr4, 1)); 

        int[] arr5 = {6, 6, 6, 6, 7, 7, 8, 8, 8};
        System.out.println(firstElementKTimes(arr5, 3)); // Output: 8
    }
}
