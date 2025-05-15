package www.oyh.com.day5_08;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sharkCode
 * @date 2025/5/8 09:29
 */
public class Solution {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.pop();
    }
    public static String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_res = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                stack_multi.push(multi);
                stack_res.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder temp = new StringBuilder();
                Integer count = stack_multi.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(res);
                }
                res = new StringBuilder( stack_res.pop() + temp);
            } else if (c >= '0' && c <= '9') {
                // 为数字
                multi = multi * 10 + Integer.parseInt(c + "");
            } else {
                // 为普通字母
                res.append(c);
            }
        }
        return res.toString();
    }
}
class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        xStack.push(val);
        minStack.push(Math.min(minStack.pop(), val));
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
