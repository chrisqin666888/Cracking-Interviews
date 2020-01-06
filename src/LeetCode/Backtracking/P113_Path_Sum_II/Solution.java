package LeetCode.Backtracking.P113_Path_Sum_II;
import java.util.*;

public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backtracking(res, new ArrayList<>(), root, sum);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> tempList, TreeNode root, int sum) {
        if (root == null) return;

        tempList.add(root.val);

        if(root.left == null && root.right == null && root.val == sum) {
            res.add(new ArrayList<>(tempList));
            tempList.remove(tempList.size() - 1);
            return;
        } else {
            backtracking(res, tempList, root.left, sum - root.val);
            backtracking(res, tempList, root.right, sum - root.val);
        }

        tempList.remove(tempList.size() - 1);
    }
}