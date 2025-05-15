package www.oyh.com.day5_14;

/**
 * @author sharkCode
 * @date 2025/5/14 16:29
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static int maxProfit(int[] prices) {
        int low = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            result = Math.max(result, prices[i] - low);
        }
        return result;
    }
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int coverRange = nums[0];
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) return true;
        }
        return false;
    }
}
