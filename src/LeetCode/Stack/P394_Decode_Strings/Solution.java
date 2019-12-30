package LeetCode.Stack.P394_Decode_Strings;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        for(int i = 0; i < s.length();) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    count = 10 * count + (s.charAt(i)) - '0';
                    i++;
                }
                counts.push(count);
            } else if (s.charAt(i) == '[') {
                result.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int count = counts.pop();
                for(int j = 0; j < count; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3[a]2[bc]";
        System.out.println(solution.decodeString(s));
    }
}
