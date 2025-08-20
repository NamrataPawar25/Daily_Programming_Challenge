import java.util.*;

public class ZeroSumSubarrays  {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        Map<Long, List<Integer>> prefixSumMap = new HashMap<>();

        long prefixSum = 0;
        prefixSumMap.put(0L, new ArrayList<>(Arrays.asList(-1))); 
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (prefixSumMap.containsKey(prefixSum)) {
                for (int startIndex : prefixSumMap.get(prefixSum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            prefixSumMap.computeIfAbsent(prefixSum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] arr1 = {4, -1, -3, 1, 2, -1};
        System.out.println("Test 1: " + format(findZeroSumSubarrays(arr1)));
   
        int[] arr2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + format(findZeroSumSubarrays(arr2)));

        int[] arr3 = {0, 0, 0};
        System.out.println("Test 3: " + format(findZeroSumSubarrays(arr3)));
        
        int[] arr4 = {-3, 1, 2, -3, 4, 0};
        System.out.println("Test 4: " + format(findZeroSumSubarrays(arr4)));
        
        int[] arr5 = {1, -1, 2, -2, 3, -3, 1, -1, 2, -2};
        System.out.println("Test 5: " + format(findZeroSumSubarrays(arr5)));
    }


    private static String format(List<int[]> result) {
        StringBuilder sb = new StringBuilder("[");
        for (int[] sub : result) {
            sb.append("(").append(sub[0]).append(", ").append(sub[1]).append("), ");
        }
        if (sb.length() > 1) sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
