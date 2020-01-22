package LeetCode.Tree_Recursion.P545_Boundary_of_Binary_Tree;
import java.util.*;

public class Solution {
    List<Integer> nodes = new ArrayList<>(1000);
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return nodes;

        nodes.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);

        return nodes;
    }

    private void leftBoundary(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;
        nodes.add(root.val);
        if(root.left == null) {
            leftBoundary(root.right);
        } else {
            leftBoundary(root.left);
        }
    }

    private void rightBoundary(TreeNode root) {
        if(root == null || (root.right == null && root.left == null)) return;
        if(root.right == null) {
            rightBoundary(root.left);
        } else {
            rightBoundary(root.right);
        }
        nodes.add(root.val);
    }

    private void leaves(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            nodes.add(root.val);
            return;
        }
        leaves(root.left);
        leaves(root.right);
    }
}





























