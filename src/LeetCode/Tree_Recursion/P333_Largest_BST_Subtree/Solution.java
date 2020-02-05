package LeetCode.Tree_Recursion.P333_Largest_BST_Subtree;

public class Solution {
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return size(root);
        }

        return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    private int size(TreeNode root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private boolean isBST(TreeNode root, int min, int max) {
        if (root == null) return true;
        if(root.val < min || root.val > max) {
            return false;
        }

        return isBST(root.left, min, root.val - 1) && isBST(root.right, root.val + 1, max);
    }
}
