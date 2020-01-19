package Interviews.Amazon.Next_Greater_Element;
// Given an array of integers, find the next greater element in order for each element.
// If there is not, set to -1;
// eg.      14 12 25 11 15
// ouput:   25,25, -1, 15 -1

import java.util.*;

public class Solution {
    public int[] nextGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);

        for(int i = 1; i < nums.length; i++) {
            if (!stack.isEmpty() && nums[i] > stack.peek()) {
                while(!stack.isEmpty() && nums[i] > stack.peek()) {
                    nextGreater.put(stack.pop(), nums[i]);
                }
            }
            stack.push(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            res[i] = nextGreater.getOrDefault(nums[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {14, 12, 25, 11, 15};
        System.out.println(Arrays.toString(solution.nextGreaterElement(input)));
    }
}
