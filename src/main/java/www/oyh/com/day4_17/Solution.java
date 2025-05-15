package www.oyh.com.day4_17;

/**
 * @author sharkCode
 * @date 2025/4/17 10:20
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world  "));
    }
    public static String reverseWords(String s) {
        // 去除多余空白
        StringBuilder sb = removeSpace(s);
        // 翻转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }
    private static StringBuilder removeSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') left++;
        while (s.charAt(right) == ' ') right--;
        StringBuilder sb = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb;
    }
    private static void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(end);
            sb.setCharAt(end, sb.charAt(start));
            sb.setCharAt(start, temp);
            start++;
            end--;

        }
    }
    private static void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
