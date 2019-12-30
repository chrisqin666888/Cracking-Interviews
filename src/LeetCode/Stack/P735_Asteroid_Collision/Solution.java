package LeetCode.Stack.P735_Asteroid_Collision;

import java.util.*;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids) {
            if(stack.isEmpty()) stack.push(a);
            else {
                while(true) {
                    int peek = stack.peek();
                    if(peek < 0) {
                        stack.push(a);
                    } else if (peek == Math.abs(a)) {
                        stack.pop();
                        break;
                    } else if (peek > Math.abs(a)) {
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }

        return res;
    }
}
