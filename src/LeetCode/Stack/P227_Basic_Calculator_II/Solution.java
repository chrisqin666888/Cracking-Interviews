package LeetCode.Stack.P227_Basic_Calculator_II;
import java.util.*;

public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (Character.isDigit(c)) {
                    i++;
                    if (i >= s.length())
                        break;
                    c = s.charAt(i);
                }
                int operand = Integer.valueOf(s.substring(start, i));
                i--;
                if (sign == '+') {
                    stack.push(operand);
                } else if (sign == '-') {
                    stack.push(-operand);
                } else if (sign == '*') {
                    stack.push(stack.pop() * operand);
                } else if (sign == '/') {
                    stack.push(stack.pop() / operand);
                }
            } else if (c != ' ') {
                sign = c;
            }
        }
        int res = 0;
        for (int i : stack) {
            res += i;
        }
        return res;
    }
}
