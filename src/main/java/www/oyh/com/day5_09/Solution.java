package www.oyh.com.day5_09;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sharkCode
 * @date 2025/5/9 09:15
 */
public class Solution {
    public static void main(String[] args) {

    }

    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()&& temperatures[stack.peek()] < temperatures[i]) {
                int pre = stack.pop();
                result[pre] = i - pre;
            }
            stack.push(i);
        }
        return result;
    }

}
