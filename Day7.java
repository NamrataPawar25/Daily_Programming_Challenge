public class TrappingRainWater  {


    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0; 

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    waterTrapped += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }

    
    public static void main(String[] args) {
        int[][] testCases = {
            {0,1,0,2,1,0,1,3,2,1,2,1},
            {4,2,0,3,2,5},
            {1,1,1},
            {5},
            {2,0,2}
        };

        int[] expected = {6, 9, 0, 0, 2};

        for (int i = 0; i < testCases.length; i++) {
            int result = trap(testCases[i]);
            System.out.println("Test " + (i+1) + ": Expected = " + expected[i] + ", Got = " + result);
        }
    }
}
