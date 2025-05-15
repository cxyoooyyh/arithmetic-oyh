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
}
