package Backtracking.P40_Combination_Sum_II;
import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), candidates, target, 0);

        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int[] candidates,
                              int target, int startIndex) {
        if (target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            }
            if(i != startIndex && candidates[i-1] == candidates[i]) continue;
            tempList.add(candidates[i]);
            backTracking(res, tempList, candidates, target - candidates[i], i+1);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        Solution s = new Solution();
        System.out.println(s.combinationSum2(candidates, 8));
    }
}
