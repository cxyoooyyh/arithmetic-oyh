package www.oyh.com.day5_21;

/**
 * @author sharkCode
 * @date 2025/5/21 10:11
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,3,3,5}));;
    }

    /**
     * 152 乘积最大子序列
     * imax = max(imax * nums[i], nums[i])
     * imin = min(imin * nums[i], nums[i])
     * max = max(max, imax);
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1;
        int imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imin;
                imin = imax;
                imax = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);
            max = Math.max(imax, max);
        }
        return max;
    }

    /**
     * 416 分割等和子集
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        // 奇数
        if ((sum & 1) == 1) {
            return false;
        }
        int length = nums.length;
        int target = (sum >> 1);

        // 定义dp数组，每项代表 该累加是否存在
        boolean[] dp = new boolean[target + 1];

        // 初始化
        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }
        for (int i = 1; i < length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            if (dp[target]) {
                return true;
            }
        }
        return dp[target];
    }
}
