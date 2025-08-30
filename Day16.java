public class LCM {

    
    private long findGCD(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

   
    public long findLCM(long n, long m) {
        if (n == 0 || m == 0) {
            return 0;
        }

        
        long gcd = findGCD(n, m);
        return (n / gcd) * m;
    }

    public static void main(String[] args) {
        LCM calculator = new LCM();

        System.out.println("Test Case 1:");
        long n1 = 4, m1 = 6;
        System.out.println("Input: N = " + n1 + ", M = " + m1);
        System.out.println("Output: " + calculator.findLCM(n1, m1)); 
        System.out.println("-------------------------");

        System.out.println("Test Case 2:");
        long n2 = 5, m2 = 10;
        System.out.println("Input: N = " + n2 + ", M = " + m2);
        System.out.println("Output: " + calculator.findLCM(n2, m2)); 
        System.out.println("-------------------------");

        System.out.println("Test Case 3:");
        long n3 = 7, m3 = 3;
        System.out.println("Input: N = " + n3 + ", M = " + m3);
        System.out.println("Output: " + calculator.findLCM(n3, m3)); 
        System.out.println("-------------------------");

        System.out.println("Test Case 4:");
        long n4 = 1, m4 = 987654321;
        System.out.println("Input: N = " + n4 + ", M = " + m4);
        System.out.println("Output: " + calculator.findLCM(n4, m4)); 
        System.out.println("-------------------------");

        System.out.println("Test Case 5:");
        long n5 = 123456, m5 = 789012;
        System.out.println("Input: N = " + n5 + ", M = " + m5);
        System.out.println("Output: " + calculator.findLCM(n5, m5)); 
        System.out.println("-------------------------");
    }
}
