package LeetCode.Array_Medium_Hard.P161_One_Edit_Distance;

public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for(int i = 0; i < Math.min(s.length(), t.length()); i++) {

            // once we find a different character
            if (s.charAt(i) != t.charAt(i)) {

                // if their length is the same
                // we check if the substring behind the distinguished character is the same as the other one
                // if not, return false
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }else if (s.length() < t.length()) {
                    // check the substring to the end, including the current char of first string
                    // with the next index substring of second string
                    return s.substring(i).equals(t.substring(i + 1));
                }
                // if the first string is longer than the second string
                else {
                    return s.substring(i + 1).equals(t.substring(i));
                }


            }
        }

        return Math.abs(s.length() - t.length()) == 1;
    }
}
