package LeetCode.DFS_Graph.P261_Graph_Validation_Tree;
import java.util.*;

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjacent_List = new ArrayList<>(n);

        // initialize vertices
        for(int i = 0; i < n; i++) {
            adjacent_List.add(i, new ArrayList<>());
        }

        // add edges
        for(int i = 0; i < edges.length; i++) {

            adjacent_List.get(edges[i][0]).add(edges[i][1]);
            adjacent_List.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];

        // make sure there is not cycle on the graph
        if (hasCycle(adjacent_List, 0, visited, -1)) {
            return false;
        }
    }

    private boolean hasCycle(List<List<Integer>> adjacent_List, int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;

        for(int i = 0; i < adjacent_List.get(vertex).size(); i++) {
            int v = adjacent_List.get(vertex).get(i);

            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjacent_List, v, visited, u)))
        }
    }
}














