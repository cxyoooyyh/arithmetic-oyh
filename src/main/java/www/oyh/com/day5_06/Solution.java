package www.oyh.com.day5_06;

import java.util.*;

/**
 * @author sharkCode
 * @date 2025/5/6 09:27
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static int kthSmallest(TreeNode root, int k) {
        // 使用中序遍历
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 加入左节点元素
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.offer(root);
        int num = queue.size();
        while (!queue.isEmpty()) {
           root = queue.remove();
           num--;
           if (root.left != null) {
               queue.offer(root.left);
           }
           if (root.right != null) {
               queue.offer(root.right);
           }
           if (num == 0) {
               list.add(root.val);
               num = queue.size();
           }
        }
        return list;
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
