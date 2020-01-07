package LeetCode.Backtracking.P131_Palindrome_Partition;
import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length() == 0) return res;
        backtracking(res, s, new ArrayList<>(), 0);
        return res;

    }

    private void backtracking(List<List<String>> res, String s, List<String> temp, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start + 1; i <= s.length(); i++) {
            if(isValid(s.substring(start, i))) {
                temp.add(s.substring(start, i));
                backtracking(res, s, temp, i);
                temp.remove(temp.size()-1);
            }
        }
    }

    private boolean isValid(String s) {
        int left = 0, right = s.length() - 1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        String input = "aab";
        Solution s = new Solution();
        System.out.println(s.partition(input));
    }
}
