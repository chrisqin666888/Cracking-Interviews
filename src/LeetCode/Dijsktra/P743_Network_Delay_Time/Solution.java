package LeetCode.Dijsktra.P743_Network_Delay_Time;
import java.util.*;

public class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for(int[] time : times) {
            map.putIfAbsent(time[0], new HashMap<>());
            map.get(time[0]).put(time[1], time[2]);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        heap.offer(new int[]{0, K});

        boolean[] visited = new boolean[N+1];
        int result = 0;

        while(!heap.isEmpty()) {
            int[] current = heap.poll();
            int current_node = current[1];
            int current_dist = current[0];
            if(visited[current_node]) continue;
            visited[current_node] = true;
            result = current_dist;
            N--;
            if(map.containsKey(current_node)) {
                for(int next_node : map.get(current_node).keySet()) {
                    heap.offer(new int[]{current_dist + map.get(current_node).get(next_node), next_node});
                }
            }
        }

        return N == 0 ? result : -1;
    }
}
