package www.oyh.com.day4_20;

import java.util.Arrays;

public class A {
    public static String reverseWords(String s) {
        StringBuffer newStr = new StringBuffer();
        for(int i = 0; i < s.length(); i++) {
            int start = i;
            while(i < s.length() && s.charAt(i) != ' ') {
                i++;
            }
            for(int j = i - 1; j >= start; j--) {
                newStr.append(s.charAt(j));
            }
            newStr.append(" ");
        }
        return newStr.toString();
    }

    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        if (length <= 1) {
            return false;
        }

        int left = 0;
        int right = length - 1;
        int sum = nums[right] - nums[left];
        while(left < right - 1) {
            if(sum > 0) {
                left++;
                sum -= nums[left];
            } else {
                right--;
                sum += nums[right];
            }

        }
        return sum == 0;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));;
    }

}