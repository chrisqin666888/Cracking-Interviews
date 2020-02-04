package LeetCode.DFS.P508_Most_Frequent_Subtree_Sum;

import java.util.*;

public class Solution {
    Map<Integer, Integer> count = new HashMap<>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> result = new ArrayList<>();
        for(int s : count.keySet()) {
            if (count.get(s) == maxCount) {
                result.add(s);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private int dfs(TreeNode root){
        if (root == null) return 0;
        int sum = dfs(root.left) + dfs(root.right) + root.val;
        count.put(sum, count.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, count.get(sum));
        return sum;
    }
}
