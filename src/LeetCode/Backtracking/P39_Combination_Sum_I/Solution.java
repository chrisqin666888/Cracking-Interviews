package LeetCode.Backtracking.P39_Combination_Sum_I;
import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backTracking(res, new ArrayList<>(), target, candidates, 0);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, int target, int[] candidates, int startIndex) {
        if(target == 0) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = startIndex; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            }

            tempList.add(candidates[i]);
            backTracking(res, tempList, target - candidates[i], candidates, i);
            tempList.remove(tempList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        Solution s = new Solution();
        System.out.println(s.combinationSum(candidates, target));
    }
}
