import java.util.*;

public class PostfixEvaluator {
    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = stack.pop();  
                int a = stack.pop(); 
                int result = applyOperator(a, b, token);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return "+-*/".contains(token);
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; 
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(evaluatePostfix("2 1 + 3 *"));    
        System.out.println(evaluatePostfix("5 6 +"));            
        System.out.println(evaluatePostfix("-5 6 -"));          
        System.out.println(evaluatePostfix("15 7 1 1 + - / 3 * 2 1 1 + + -")); 
        System.out.println(evaluatePostfix("5"));                
    }
}
