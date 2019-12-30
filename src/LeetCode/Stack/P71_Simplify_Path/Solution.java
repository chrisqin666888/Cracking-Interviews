package LeetCode.Stack.P71_Simplify_Path;
import java.util.*;

public class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");

        for(int i = 0; i < arr.length; i++) {
            String curr = arr[i].trim();
            if (curr == null || curr.length() == 0 || curr.equals(".")) continue;

            if(curr.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(curr);
            }
        }

        String res = "";

        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }

        return res.length() == 0 ? "/" : res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.simplifyPath("/a/./b/../../c/"));
    }
}
