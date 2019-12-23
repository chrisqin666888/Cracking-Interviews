package Backtracking.P47_Permutation_II;

import java.util.*;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        backTracking(res, new ArrayList<>(), new HashSet<>(), nums);
        return res;
    }

    private void backTracking(List<List<Integer>> res, List<Integer> tempList, HashSet<Integer> visited, int[] nums) {
        if(tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if (visited.contains(i)) continue;
            if(i > 0 && nums[i] == nums[i-1] && !visited.contains(i-1)) continue;
            tempList.add(nums[i]);
            visited.add(i);
            backTracking(res, tempList, visited, nums);
            visited.remove(i);
            tempList.remove(tempList.size()-1);
        }
    }



    public static void main(String[] args) {
        int[] nums = {1,1,2};

        Solution s = new Solution();
        System.out.println(s.permuteUnique(nums));
    }
}

