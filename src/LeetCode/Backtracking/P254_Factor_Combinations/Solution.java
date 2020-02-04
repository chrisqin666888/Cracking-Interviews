package LeetCode.Backtracking.P254_Factor_Combinations;
import java.util.*;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(result, new ArrayList<>(), n, 2);
        return result;
    }


    private void backtracking(List<List<Integer>> result, List<Integer> tempList, int n, int start) {
        if (n <= 1) {
            if (tempList.size() > 1) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        for(int i = start; i <= n; i++) {
            if (n % i == 0) {
                tempList.add(i);
                backtracking(result, tempList, n / i, i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getFactors(12));
    }
}
