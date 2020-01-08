package LeetCode.Backtracking.P216_Combination_Sum_III;
import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 0) return res;

        backtracking(res, new ArrayList<>(), 1, k, n);
        return res;
    }

    private void backtracking(List<List<Integer>> res, List<Integer> tempList, int start, int k, int n) {
        if (n == 0 && tempList.size() == k) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = start; i <= 9; i++) {
            if(tempList.size() > k || i > n) break;
            tempList.add(i);
            backtracking(res, tempList, i+1, k, n - i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum3(3, 7));

    }
}
