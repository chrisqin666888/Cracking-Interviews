package LeetCode.Sliding_Window.P76_Minimum_Window_Substring;

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int matchCount = 0;
        String result = "";
        int[] t_arr = new int[256];
        for(char c : t.toCharArray()) {
            t_arr[c]++;
        }

        int[] s_arr = new int[256];
        int left = findNextStrIndex(0, s, t_arr);
        if(left == s.length()) return "";
        int right = left;

        while(right < s.length()) {
            int right_char = s.charAt(right);
            if (s_arr[right_char] < t_arr[right_char]) matchCount++;
            s_arr[right_char]++;

            while(left < s.length() && matchCount == t.length()) {
                if (result.isEmpty() || result.length() > right - left + 1) {
                    result = s.substring(left, right + 1);
                }
                int left_char = s.charAt(left);
                if (s_arr[left_char] <= t_arr[left_char]) matchCount--;

                s_arr[left_char]--;
                left = findNextStrIndex(left + 1, s, t_arr);
            }
            right = findNextStrIndex(right + 1, s, t_arr);
        }
        return result;
    }

    private int findNextStrIndex(int start, String s, int[] t_arr) {
        while(start < s.length()) {
            char c = s.charAt(start);
            if (t_arr[c] != 0) return start;
            start++;
        }
        return start;
    }
}
