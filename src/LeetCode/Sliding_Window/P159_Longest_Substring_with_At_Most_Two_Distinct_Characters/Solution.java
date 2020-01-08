package LeetCode.Sliding_Window.P159_Longest_Substring_with_At_Most_Two_Distinct_Characters;
import java.util.*;

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() < 3) return s.length();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int max_length = 2;

        while(right < s.length()) {
            if (map.size() < 3) {
                map.put(s.charAt(right), right++);
            }

            if (map.size() == 3) {
                int delete_index = Collections.min(map.values());
                map.remove(s.charAt(delete_index));
                left = delete_index + 1;
            }

            max_length = Math.max(max_length, right - left);
        }


        return max_length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstringTwoDistinct("leeeeeetcoooooooooode"));
    }
}

//    l e e e e e e e e t c o o o o o o o o o d e

