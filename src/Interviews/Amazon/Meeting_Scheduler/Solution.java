package Interviews.Amazon.Meeting_Scheduler;

import java.util.*;

//Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration,
//        return the earliest time slot that works for both of them and is of duration duration.
//
//        If there is no common time slot that satisfies the requirements, return an empty array.
//
//        The format of a time slot is an array of two elements [start, end] representing an inclusive time range from
//        start to end.
//
//        It is guaranteed that no two availability slots of the same person intersect with each other. That is,
//        for any two time slots [start1, end1] and [start2, end2] of the same person,
//        either start1 > end2 or start2 > end1.
//
//
//
//        Example 1:
//
//        Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
//        Output: [60,68]
//        Example 2:
//
//        Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
//        Output: []

public class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        // Solution
        // 1. Put both slots1 and slots2 into PriorityQueue/heapq (first filter slots shorter than duration),
        // sort by starting time;
        // 2. Pop out the slots one by one, comparing every consecutive two to check if having duration time in common.
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int[] slot : slots1) {
            if (slot[1] - slot[0] >= duration) {
                heap.offer(slot);
            }
        }
        for(int[] slot : slots2) {
            if (slot[1] - slot[0] >= duration) {
                heap.offer(slot);
            }
        }

        while (heap.size() > 1) {
            if (heap.poll()[1] >= heap.peek()[0] + duration) {
                return Arrays.asList(heap.peek()[0], heap.peek()[0] + duration);
            }
        }
        return Arrays.asList();
    }

    public static void main(String[] args) {
        int[][] input1 = {{10,50},{140,210}, {60,120}};
        int[][] input2 = {{0,15},{60,70}};
        int duration = 8;
        LeetCode.PriorityQueue.P1229_Meeting_Scheduler.Solution solution = new LeetCode.PriorityQueue.P1229_Meeting_Scheduler.Solution();
        System.out.println(solution.minAvailableDuration(input1, input2, duration));
    }
}
