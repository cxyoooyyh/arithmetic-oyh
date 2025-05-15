package www.oyh.com.day5_02;

/**
 * @author sharkCode
 * @date 2025/5/2 14:52
 */
public class Solution {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }
    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;
        int middle = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[middle]);
        root.left = traversal(nums, left, middle - 1);
        root.right = traversal(nums, middle + 1, right);
        return root;
    }
    TreeNode max;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // left
        boolean left = isValidBST(root.left);
        if (!left) {
            return false;
        }
        // middle
        if (max != null && max.val >= root.val) {
            return false;
        }
        max = root;
        // right
        return isValidBST(root.right);
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

