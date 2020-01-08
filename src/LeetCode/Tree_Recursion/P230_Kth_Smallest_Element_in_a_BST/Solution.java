package LeetCode.Tree_Recursion.P230_Kth_Smallest_Element_in_a_BST;
import java.util.*;

public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums = inorderTraversal(root, new ArrayList<>());
        return nums.get(k - 1);
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> arr) {
        if(root == null) return arr;
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
        return arr;
    }
}
