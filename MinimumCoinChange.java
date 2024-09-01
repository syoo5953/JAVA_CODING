import java.util.Arrays;

public class MinimumCoinChange {

    public static int coinChange(int[] coins, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[n] > n ? -1 : dp[n];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int n = 11;
        int result = coinChange(coins, n);

        System.out.println("Minimum number of coins needed: " + result);
    }
}
