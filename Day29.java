import java.math.BigInteger;

public class Fibonacci {
    public BigInteger fibonacci(int n) {
        if (n < 0 || n > 1000) {
            throw new IllegalArgumentException("Input n must be between 0 and 1000.");
        }

  
        if (n == 0) {
            return BigInteger.ZERO;
        }

        if (n == 1) {
            return BigInteger.ONE;
        }

        BigInteger[] fib = new BigInteger[n + 1];

  
        fib[0] = BigInteger.ZERO;
        fib[1] = BigInteger.ONE;


        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        return fib[n];
    }
   
    public static void main(String[] args) {
        Fibonacci fibonacciCalculator = new Fibonacci();

        int n1 = 5;
        System.out.println("The " + n1 + "-th Fibonacci number is: " + fibonacciCalculator.fibonacci(n1));


        int n2 = 10;
        System.out.println("The " + n2 + "-th Fibonacci number is: " + fibonacciCalculator.fibonacci(n2));

        int n3 = 0;
        System.out.println("The " + n3 + "-th Fibonacci number is: " + fibonacciCalculator.fibonacci(n3));

        int n4 = 1000;
        System.out.println("The " + n4 + "-th Fibonacci number is: " + fibonacciCalculator.fibonacci(n4));
    }
}
