package LeetCode.Tree_Recursion.P501_Find_Mode_in_Binary_Search_Tree;
import java.util.*;

public class Solution {
    Integer prev = null;
    int freq = 1;
    int maxFreq = 0;
    public int[] findMode(TreeNode root) {
        List<Integer> modes = new ArrayList<>();

        traverse(root, modes);

        int[] result = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void traverse(TreeNode node, List<Integer> modes) {
        if (node == null) return;
        traverse(node.left, modes);
        if(prev != null) {
            if (prev == node.val) {
                freq++;
            } else {
                freq = 1;
            }
        }

        if (freq > maxFreq) {
            maxFreq = freq;
            modes.clear();
            modes.add(node.val);
        } else if (freq == maxFreq) {
            modes.add(node.val);
        }
        prev = node.val;

        traverse(node.right, modes);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findMode(root)));
    }
}
