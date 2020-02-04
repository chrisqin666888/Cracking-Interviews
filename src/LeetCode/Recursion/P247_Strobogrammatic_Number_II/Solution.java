package LeetCode.Recursion.P247_Strobogrammatic_Number_II;
import java.util.*;

public class Solution {
    public List<String> findStrobogrammatci(int n) {
        return helper(n, n);
    }

    private List<String> helper(int curLen, int n) {
        if (curLen == 0) return new ArrayList<>(Arrays.asList(""));
        if (curLen == 1) return new ArrayList<>(Arrays.asList("1", "8", "0"));
        List<String> sub = helper(curLen - 2, n);
        List<String> cur = new ArrayList<>();
        for(String s : sub) {
            if (curLen != n) {
                cur.add("0" + s + "0");
            }
            cur.add("6" + s + "9");
            cur.add("9" + s + "6");
            cur.add("8" + s + "8");
            cur.add("1" + s + "1");
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findStrobogrammatci(2));
    }
}
