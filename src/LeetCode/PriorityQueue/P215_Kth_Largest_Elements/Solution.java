package LeetCode.PriorityQueue.P215_Kth_Largest_Elements;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);

        for(int num : nums) {
            q.add(num);
            if(q.size() >= k) {
                q.poll();
            }
        }

        return q.poll();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = new int[]{3,2,1,5,6,4};
        System.out.println(s.findKthLargest(input, 5));
    }
}
