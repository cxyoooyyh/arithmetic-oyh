package www.oyh.com.day4_16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author sharkCode
 * @date 2025/4/16 10:34
 */
public class Solution {
    public static void main(String[] args) {
        reverseString(new char[]{'h','e','l','l', 'o'});
    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        boolean flag = true;
        for (int i : record) {
            if (i > 0) {
                return false;
            }
        }
        return flag;
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 ||nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> tempSet = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            tempSet.add(i);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (tempSet.contains(i)) {
                resSet.add(i);
            }
        }
        return resSet.stream().mapToInt(Integer::intValue).toArray();
    }
    public boolean isHappy(int n) {
        Set<Integer> resSet = new HashSet<>();
        while (n != 1 && !resSet.contains(n)) {
            resSet.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            res += temp * temp;
            n = n / 10;
        }
        return res;
    }
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                int temp = num1 + num2;
                hashMap.put(temp, hashMap.getOrDefault(temp, 0) + 1);
            }
        }
        for (int num3 : nums3) {
            for (int num4 : nums4) {
                int temp = num3 + num4;
                count += hashMap.getOrDefault(-temp, 0);
            }
        }
        return count;
    }

    /**
     * magazine字符串的字母是否能构成 ransomNote
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        for (int s : magazine.toCharArray()) {
            record[s - 'a']++;
        }
        for (int s : ransomNote.toCharArray()) {
            record[s - 'a']--;
            if (record[s - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
    public static void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[s.length - i - 1];
            s[s.length - i - 1] = s[i];
            s[i] = temp;
        }
        System.out.println(s);
    }
}

