package www.oyh.com.day4_30;

/**
 * @author sharkCode
 * @date 2025/4/30 09:29
 */
public class Solution {
    public static void main(String[] args) {

    }
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        swapChildren(root);
        return root;
    }
    private static void swapChildren(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    public static boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
    private static boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        // 比较外侧
        boolean compareOutside = compare(left.left, right.right);
        // 内侧
        boolean compareInside = compare(left.right, right.left);
        return compareOutside && compareInside;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
