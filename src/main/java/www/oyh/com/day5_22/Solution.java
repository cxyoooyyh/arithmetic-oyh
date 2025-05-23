package www.oyh.com.day5_22;

/**
 * @author sharkCode
 * @date 2025/5/22 15:30
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        for(int item : nums) {
            result ^= item;
        }
        return result;
    }
    public static int majorityElement(int[] nums) {
        int winner = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (winner == nums[1]) {
                count++;
            } else if (count == 0) {
                winner = nums[i];
                count++;
            } else {
                count--;
            }
        }
        return winner;
    }
}
