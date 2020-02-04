package LeetCode.BFS.P515_Find_Largest_Value_in_Each_Tree_Row;
import java.util.*;

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            int max_val = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++) {
                TreeNode current_node = queue.poll();
                if (current_node.val > max_val) {
                    max_val = current_node.val;
                }

                if (current_node.left != null) queue.offer(current_node.left);
                if (current_node.right != null) queue.offer(current_node.right);
            }
            result.add(max_val);
        }

        return result;
    }
}
