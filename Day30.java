import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
       
        int[] dp = new int[amount + 1];
        
        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
       
                if (coin <= i) {
            
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        if (dp[amount] > amount) {
            return -1;
        } else {
            return dp[amount];
        }
    }

    public static void main(String[] args) {
        CoinChange solution = new CoinChange();

        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        System.out.println("Input: coins = " + Arrays.toString(coins1) + ", amount = " + amount1);
        System.out.println("Output: " + solution.coinChange(coins1, amount1)); 

        System.out.println();

        int[] coins2 = {2};
        int amount2 = 3;
        System.out.println("Input: coins = " + Arrays.toString(coins2) + ", amount = " + amount2);
        System.out.println("Output: " + solution.coinChange(coins2, amount2));

        System.out.println();

        int[] coins3 = {1};
        int amount3 = 0;
        System.out.println("Input: coins = " + Arrays.toString(coins3) + ", amount = " + amount3);
        System.out.println("Output: " + solution.coinChange(coins3, amount3)); 
    }
}
