package LeetCode.Sliding_Window.P424_Longest_Repeating_Character_Replacement;

public class Solution {
    public int characterReplacement(String s, int k) {
        int max = 0;
        int maxLength = 0;
        int[] dict = new int[256];
        int left = 0, right = 0;

        while (right < s.length()) {
            dict[s.charAt(right)]++;
            maxLength = Math.max(maxLength, dict[s.charAt(right)]);
            while((right - left + 1 - maxLength > k)) {
                dict[s.charAt(left)]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("AABABBA", 1));
    }
}
