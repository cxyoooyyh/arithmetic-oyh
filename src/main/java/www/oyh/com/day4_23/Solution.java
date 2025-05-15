package www.oyh.com.day4_23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sharkCode
 * @date 2025/4/23 09:56
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 1; j < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                j++;
                continue;
            }
            while(j < nums.length - 1 && nums[j] == 0) {
                j++;
            }
        }
    }
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int answer = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            answer = Math.max(answer, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
    // 三数之和
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
               return result;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
