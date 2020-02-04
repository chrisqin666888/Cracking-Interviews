package LeetCode.BFS_Graph.P310_Minimum_Height_Trees;
import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }

        int[] degrees = new int[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for(int[] pair: edges) {
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
            degrees[pair[0]]++;
            degrees[pair[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(degrees[i] == 1) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int current = queue.poll();
                list.add(current);
                for(int connected_vertice : graph.get(current)) {
                    degrees[connected_vertice]--;
                    if(degrees[connected_vertice] == 1) queue.offer(connected_vertice);
                }
            }
            result = list;
        }
        return result;
    }
}
