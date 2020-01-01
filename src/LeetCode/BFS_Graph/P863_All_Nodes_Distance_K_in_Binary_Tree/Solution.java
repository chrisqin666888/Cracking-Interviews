package LeetCode.BFS_Graph.P863_All_Nodes_Distance_K_in_Binary_Tree;

import java.util.*;

public class Solution {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        buildMap(root, null);

        if(!map.containsKey(target)) return res;

        Set<TreeNode> visitedNode = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visitedNode.add(target);

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (K == 0) {
                for(int i = 0; i < size; i++) {
                    res.add(queue.poll().val);
                }
                return res;
            }

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                for(TreeNode next : map.get(node)) {
                    if (visitedNode.contains(next)) continue;
                    visitedNode.add(next);
                    queue.add(next);
                }
            }
            K--;
        }
        return res;
    }

    private void buildMap(TreeNode node, TreeNode parent) {
        if (node == null) return;
        if (!map.containsKey(node)) {
            map.put(node, new ArrayList<TreeNode>());
            if (parent != null) {
                map.get(node).add(parent);
                map.get(parent).add(node);
            }
            buildMap(node.left, node);
            buildMap(node.right, node);
        }
    }
}
