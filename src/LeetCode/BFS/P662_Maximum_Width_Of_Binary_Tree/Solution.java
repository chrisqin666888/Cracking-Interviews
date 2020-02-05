package LeetCode.BFS.P662_Maximum_Width_Of_Binary_Tree;
import java.util.*;

public class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> level_index = new LinkedList<>();
        queue.offer(root);
        level_index.offer(1);
        int max_width = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int start = 0, end = 0;
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                int index = level_index.poll();

                if (i == 0) start = index;
                if (i == size - 1) end = index;
                if (node.left != null) {
                    queue.offer(node.left);
                    level_index.offer(2 * index);
                }

                if (node.right != null) {
                    queue.offer(node.left);
                    level_index.offer(2 * index);
                }
            }
            max_width = Math.max(max_width, end - start + 1);
        }
        return max_width;
    }
}
