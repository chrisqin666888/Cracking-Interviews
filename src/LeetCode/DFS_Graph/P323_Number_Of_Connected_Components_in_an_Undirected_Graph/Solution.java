package LeetCode.DFS_Graph.P323_Number_Of_Connected_Components_in_an_Undirected_Graph;
import java.util.*;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;

        List<List<Integer>> adjacent_List = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjacent_List.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            adjacent_List.get(edge[0]).add(edge[1]);
            adjacent_List.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(visited, i, adjacent_List);
            }
        }

        return count;
    }

    private void dfs(boolean[] visited, int index, List<List<Integer>> adjacent_List) {
        visited[index] = true;
        for(int i : adjacent_List.get(index)) {
            if(!visited[i]) {
                dfs(visited, i, adjacent_List);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(solution.countComponents(5, edges));
    }
}








