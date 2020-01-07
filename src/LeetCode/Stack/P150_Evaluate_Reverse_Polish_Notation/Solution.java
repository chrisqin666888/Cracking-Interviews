package LeetCode.Stack.P150_Evaluate_Reverse_Polish_Notation;
import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int bb = stack.pop();
                    int aa = stack.pop();
                    stack.push(aa / bb);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.pop();
    }
}
