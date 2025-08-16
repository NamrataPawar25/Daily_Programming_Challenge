public class MissingNumberFinder {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1; 
        long expectedSum = (long) n * (n + 1) / 2; 
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int)(expectedSum - actualSum);
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5};
        System.out.println("Missing number: " + findMissingNumber(arr1));

        int[] arr2 = {2, 3, 4, 5};
        System.out.println("Missing number: " + findMissingNumber(arr2));

        int[] arr3 = {1, 2, 3, 4};
        System.out.println("Missing number: " + findMissingNumber(arr3));

        int[] arr4 = {1};
        System.out.println("Missing number: " + findMissingNumber(arr4));
    }
}
