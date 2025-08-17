public class FindDuplicateNumber  {

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; 
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 4, 2, 2};
        System.out.println("Duplicate in arr1: " + findDuplicate(arr1));

        int[] arr2 = {3, 1, 3, 4, 2};
        System.out.println("Duplicate in arr2: " + findDuplicate(arr2)); 

        int[] arr3 = {1, 1};
        System.out.println("Duplicate in arr3: " + findDuplicate(arr3));

        int[] arr4 = {1, 4, 4, 2, 3};
        System.out.println("Duplicate in arr4: " + findDuplicate(arr4));

        int[] arr5 = new int[100000]; // n+1 = 100000
        for (int i = 0; i < 99999; i++) {
            arr5[i] = i + 1; 
        }
        arr5[99999] = 50000; 
        System.out.println("Duplicate in arr5: " + findDuplicate(arr5));
    }
}
