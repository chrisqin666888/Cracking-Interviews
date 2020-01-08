package LeetCode.Sliding_Window.P438_Find_All_Anagrams_in_a_String;
import java.util.*;

public class Solution {
    String anagram;
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() == 0 || p.length() == 0) return res;

        char[] temp = p.toCharArray();
        Arrays.sort(temp);
        anagram = new String(temp);

        for(int i = 0; i < s.length() - p.length() + 1; i++) {
            String candidate = s.substring(i, i + p.length());

            if(isAnagram(candidate)) {
                res.add(i);
                i += p.length();
            }
        }


        return res;
    }

    private boolean isAnagram(String target) {

        char[] temp = target.toCharArray();
        Arrays.sort(temp);
       return anagram.equals(new String(temp));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}
