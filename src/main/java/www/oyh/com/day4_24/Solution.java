package www.oyh.com.day4_24;

import java.util.*;

/**
 * @author sharkCode
 * @date 2025/4/24 09:44
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }
    public int trap(int[] height) {
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            if(leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        int right = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 移动左边界
            if (i != 0) {
                occ.remove(s.charAt(i));
            }
            // 记录长度 和 加入 occ
            while (right + 1 < n && !occ.contains(s.charAt(right + 1))) {
                occ.add(s.charAt(right + 1));
                right++;
            }
            ans = Math.max(ans, occ.size());
        }
        return ans;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        if (sn < pn) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pn; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 0; i < sn - pn; i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pn) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
