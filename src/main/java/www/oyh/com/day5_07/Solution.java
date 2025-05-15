package www.oyh.com.day5_07;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author sharkCode
 * @date 2025/5/7 09:44
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static void flatten(TreeNode root) {
        while (root != null) {
            // 左子树为空，右移
            if (root.left == null) {
                root = root.right;
            } else {
                // 寻找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                // 将原来右子树移到左子树最右边节点
                pre.right = root.right;
                // 将左子树插入到右边位置
                root.right = root.left;
                root.left = null;
                // 右移
                root = root.right;
            }
        }
    }
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || !stack.peek().equals(s.charAt(i))) {
                if(s.charAt(i) == '(') {
                    stack.push(')');
                } else if (s.charAt(i) == '{') {
                    stack.push('}');
                } else if (s.charAt(i) == '[') {
                    stack.push(']');
                }

            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
