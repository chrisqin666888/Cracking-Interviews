package LeetCode.Backtracking.P77_Combination;
import java.util.*;

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) return res;
        backtracking(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private void backtracking(int n, int k, int start_num, List<List<Integer>> res, List<Integer> tempList) {
        if (k == 0) res.add(new ArrayList<>(tempList));
        else {
            for(int i = start_num; i <= n; i++) {
                tempList.add(i);
                backtracking(n, k-1, i + 1, res, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }

    }
}
