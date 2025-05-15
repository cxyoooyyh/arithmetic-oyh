package www.oyh.com.day4_22;

import java.util.*;

/**
 * @author sharkCode
 * @date 2025/4/22 11:20
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = arr.toString();
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(s);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    public int longestConsecutive(int[] nums) {
        Set<Integer> num_set =  new HashSet<>();
        // HashSet 去重
        for (int num : nums) {
            num_set.add(num);
        }
        int longestSteak = 0;
        for (int num : num_set) {
            // 判断是否有上一个连续,没有则向下计数
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    num++;
                    currentStreak++;
                }
                longestSteak = Math.max(currentStreak, longestSteak);
            }
        }
        return longestSteak;
    }
}
