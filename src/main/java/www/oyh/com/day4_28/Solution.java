package www.oyh.com.day4_28;

/**
 * @author sharkCode
 * @date 2025/4/28 15:52
 */
public class Solution {
    public static void main(String[] args) {

    }
    // [-1, -2, -3, 4, 5, -1, 20]
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            // 取大值
            if (count > result) result = count;
            // 为负数一定会变小，所以从这里开始计算
            if (count <= 0) count = 0;
        }
        return result;
    }
}

