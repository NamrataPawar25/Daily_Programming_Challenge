import java.util.Stack;

public class SortStackRecursion {

  
    private static void sortedInsert(Stack<Integer> stack, int element) {
      
        if (stack.isEmpty() || element > stack.peek()) {
            stack.push(element);
            return;
        }

        
        int top = stack.pop();
        sortedInsert(stack, element);

        
        stack.push(top);
    }


    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            
            int top = stack.pop();

            
            sortStack(stack);

            
            sortedInsert(stack, top);
        }
    }

    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
  }
