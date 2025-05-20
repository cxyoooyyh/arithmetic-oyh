package www.oyh.com.day5_20;

import java.util.Arrays;
import java.util.List;

/**
 * @author sharkCode
 * @date 2025/5/20 09:19
 */
public class Solution {
    public static void main(String[] args) {

    }

    /**
     * 139 动态规划
     * if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) dp[i] = true
     * @param s
     * @param wordDict
     * @return
     */
    // "abc" ["a", "b", "ab"]
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
    /**
     * 300
     * @param nums
     * @return
     * if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
     * dp 数组含义为 递增的长度
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int result = 1;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(dp[i], result);
        }
        return result;
    }
}
