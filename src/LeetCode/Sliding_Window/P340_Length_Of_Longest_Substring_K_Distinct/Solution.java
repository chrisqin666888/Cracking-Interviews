package LeetCode.Sliding_Window.P340_Length_Of_Longest_Substring_K_Distinct;
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length();
        if(n * k == 0) return 0;

        int left = 0, right = 0;

        Map<Character, Integer> count = new HashMap<>();

        int max_len = 1;

        while(right < n) {
            count.put(s.charAt(right), right++);

            if(count.size() == k + 1) {
                int del_idx = Collections.min(count.values());
                count.remove(s.charAt(del_idx));
                left = del_idx + 1;
            }

            max_len = Math.max(max_len, right - left);
        }

        return max_len;
    }
}
