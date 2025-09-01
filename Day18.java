import java.util.Scanner;

public class NumberOfDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long N = sc.nextLong();
        sc.close();
        System.out.println(countDivisors(N));
    }

    public static int countDivisors(long n) {
        int count = 0;
        long sqrtN = (long)Math.sqrt(n);

        for (long i = 1; i <= sqrtN; i++) {
            if (n % i == 0) {
                count++;
                
                if (i != n / i) {
                    count++;
                }
            }
        }
        return count;
    }
}
