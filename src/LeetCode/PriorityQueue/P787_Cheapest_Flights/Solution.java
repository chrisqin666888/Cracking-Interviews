package LeetCode.PriorityQueue.P787_Cheapest_Flights;

import java.util.PriorityQueue;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] graph = new int[n][n];
        for(int[] flight : flights) {
            graph[flight[0]][flight[1]] = flight[2];
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        heap.offer(new int[]{0, src, K + 1});

        while(!heap.isEmpty()) {
            int[] cur = heap.poll();
            int cost = cur[0], place = cur[1], remainStops = cur[2];

            if (place == dst) return cost;
            if (remainStops > 0) {
                for(int i = 0; i < n; i++) {
                    if (graph[place][i] > 0) {
                        heap.offer(new int[]{cost + graph[place][i], i, remainStops - 1});
                    }
                }
            }
        }

        return -1;
    }
}
