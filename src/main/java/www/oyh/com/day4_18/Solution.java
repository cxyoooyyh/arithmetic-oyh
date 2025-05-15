package www.oyh.com.day4_18;

import java.util.Stack;

public class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != ch) {
                stack.push(ch);
            }  else {
                stack.pop();
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        return str;
    }

    public static void main(String[] args) {

    }
}