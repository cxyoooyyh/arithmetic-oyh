package www.oyh.com.day5_15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sharkCode
 * @date 2025/5/15 11:12
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        // 记录跳跃次数
        int count = 0;
        // 当前覆盖区域
        int curDistance = 0;
        // 最大覆盖区域
        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            maxDistance = Math.max(maxDistance, i + nums[i]);
            if (maxDistance >= nums.length - 1) {
                // 退出并且 count+1
                count++;
                break;
            }
            //走到当前最大覆盖区域时
            if (curDistance == i) {
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
    public List<Integer> partitionLabels(String s) {
        // 记录每个字母最远下标
        // 当前面记录的最远下标等于当前下标时，分割
        List<Integer> result = new ArrayList<>();
        int[] last = new int[26];
        char[] sChar = s.toCharArray();
        // 记录最远下标
        for (int i = 0; i < sChar.length; i++) {
            last[sChar[i] - 'a'] = i;
        }
        int max = 0;
        // 上次下标
        int lastIndex = 0;
        // 遍历 "aabb"
        for (int i = 0; i < sChar.length; i++) {
            // 最远下标
            max = Math.max(max, last[sChar[i] - 'a']);
            if (max == i) {
                result.add(i - lastIndex);
                lastIndex = i;
            }
        }
        return result;
    }
    /**
     * 70.爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * dp[n] = dp[n - 1] + dp[n]
     */
    public static int climbStairs (int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
