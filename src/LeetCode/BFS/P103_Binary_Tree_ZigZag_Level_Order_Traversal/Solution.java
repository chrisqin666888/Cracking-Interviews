package LeetCode.BFS.P103_Binary_Tree_ZigZag_Level_Order_Traversal;
import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean zigzag = false;

        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int count = queue.size();
            for(int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    level.add(0, node.val);
                } else {
                    level.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(level);
            zigzag = !zigzag;
        }
        return result;
    }
}
