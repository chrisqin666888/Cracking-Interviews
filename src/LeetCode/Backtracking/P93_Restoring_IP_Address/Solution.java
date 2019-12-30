package LeetCode.Backtracking.P93_Restoring_IP_Address;
import java.util.*;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backTracking(s, res, 0, 4, "");
        return res;
    }

    private void backTracking(String s, List<String> res, int index, int remain, String cur) {
        if (remain == 0) {
            if (index == s.length()) {
                res.add(cur);
            }
            return;
        }

        for(int i = 1; i <= 3; i++) {
            if(index + i > s.length()) break;
            if(i != 1 && s.charAt(index) == '0') break;

            String temp = s.substring(index, index + i);
            int val = Integer.parseInt(temp);

            if (val <= 255) {
                backTracking(s, res, index + i, remain - 1, cur + temp + (remain == 1 ? "" : "."));
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("25525511135"));
    }
}
