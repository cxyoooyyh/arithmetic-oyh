package www.oyh.com.day5_19;

/**
 * @author sharkCode
 * @date 2025/5/19 15:00
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 完全平方数 279
     * 动态规划 完全背包问题
     * i为每项  i方 为 j
     * 递推公式为 dp[j] = min(dp[j - i * i] + 1, dp[j])
     * @param n
     * @return
     */
    public static int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != max) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

    /**
     * 322 零钱兑换
     * 状态方程 dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = max;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
