import java.util.Stack;

public class ReverseStack {

    public static void insertAtBottom(Stack<Integer> stack, int element) {
        if (stack.isEmpty()) {
            stack.push(element);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, element);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }


    public static Stack<Integer> createStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int value : arr) {
            stack.push(value);
        }
        return stack;
    }

    public static void testCase(int[] inputArr) {
        Stack<Integer> stack = createStack(inputArr);
        System.out.println("Original Stack: " + stack);
        reverse(stack);
        System.out.println("Reversed Stack: " + stack);
        System.out.println("---------------------------");
    }


    public static void main(String[] args) {

        System.out.println("Test Case 1:");
        testCase(new int[]{3, 2, 1}); 

        System.out.println("Test Case 2:");
        testCase(new int[]{5}); 

        System.out.println("Test Case 3:");
        testCase(new int[]{-5, -10, -15}); 

        System.out.println("Test Case 4:");
        testCase(new int[]{}); 

        System.out.println("Test Case 5:");
        testCase(new int[]{3, 3, 3}); 
    }
}
