import java.util.Arrays;

public class MaximumCoinChange {

    public static int maxCoinChange(int[] coins, int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0; // 0원을 만드는 방법은 동전을 하나도 사용하지 않는 것

        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                if (dp[i - coin] != Integer.MIN_VALUE) {
                    dp[i] = Math.max(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[n] < 0 ? -1 : dp[n];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int n = 11;
        int result = maxCoinChange(coins, n);

        System.out.println("Maximum number of coins that can be used: " + result);
    }
}
