import java.util.Arrays;

public class MergeSortedArrays  {

    
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void merge(int[] arr1, int[] arr2, int m, int n) {
        int gap = m + n;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            int i, j;

            for (i = 0; i + gap < m; i++) {
                if (arr1[i] > arr1[i + gap]) {
                    int temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

            
            for (j = gap > m ? gap - m : 0; i < m && j < n; i++, j++) {
                if (arr1[i] > arr2[j]) {
                    int temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            
            if (j < n) {
                for (j = 0; j + gap < n; j++) {
                    if (arr2[j] > arr2[j + gap]) {
                        int temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }


    private static void printArrays(int[] arr1, int[] arr2) {
        System.out.println("arr1 = " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));
        System.out.println();
    }

    public static void main(String[] args) {
  
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Test Case 1:");
        printArrays(arr1, arr2);

        arr1 = new int[]{10, 12, 14};
        arr2 = new int[]{1, 3, 5};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Test Case 2:");
        printArrays(arr1, arr2);

        arr1 = new int[]{2, 3, 8};
        arr2 = new int[]{4, 6, 10};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Test Case 3:");
        printArrays(arr1, arr2);

        arr1 = new int[]{1};
        arr2 = new int[]{2};
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Test Case 4:");
        printArrays(arr1, arr2);

        int size = 10;
        arr1 = new int[size];
        arr2 = new int[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = i + 1;
            arr2[i] = i + size / 2 + 1;
        }
        merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println("Test Case 5 (demo with size=10):");
        printArrays(arr1, arr2);
    }
}
