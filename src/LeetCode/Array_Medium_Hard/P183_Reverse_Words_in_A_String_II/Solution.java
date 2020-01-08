package LeetCode.Array_Medium_Hard.P183_Reverse_Words_in_A_String_II;

public class Solution {
    public void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(0, s.length - 1, s);
        // 2, reverse each word
        int start = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(start, i-1, s);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(start, s.length - 1, s);
    }

    private void reverse(int start, int end, char[] s) {
        while(start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
