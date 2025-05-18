package www.oyh.com.day5_18;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sharkCode
 * @date 2025/5/18 23:17
 */
public class Solution {
    public static void main(String[] args) {
        rob(null);
    }

    /**
     * 杨辉三角 118.
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(List.of(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }
    /**
     * 打家劫舍 198.
     *
     */
    public static int rob(int[] nums) {
       // 动态规划  dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[dp.length - 1];
    }
}
