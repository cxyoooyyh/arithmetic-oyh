package www.oyh.com.day5_23;

import java.util.Arrays;

/**
 * @author sharkCode
 * @date 2025/5/23 14:26
 */
public class Solution {
    public static void main(String[] args) {
        int[][] matrix =
                new int[][] {
                        new int[] {1,3,5,7},
                        new int[] {10,11,16,20},
                        new int[] {23,30,34,60}
                };
        searchMatrix(matrix, 3);
    }
    /**
     * 75 颜色分类 双指针
     * p0放在1开头(交换0), p1放在2开头(交换1)
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int p0 = 0, p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                // 交换1后 p1 进位
                p1++;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    // 交换p1
                    temp = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = temp;
                }
                p0++;
                p1++;
            }
        }
    }
    /**
     * 二分查找 74
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = -1;
        int right = m * n;
        while (left + 1 < right) {
            int middle = (left + right) >>> 1;
            int x = matrix[middle / n][middle % n];
            if (x == target) {
                return true;
            }
            if (x < target) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return false;
    }
}
