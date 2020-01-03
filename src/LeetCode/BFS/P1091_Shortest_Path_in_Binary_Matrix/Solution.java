package LeetCode.BFS.P1091_Shortest_Path_in_Binary_Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        if(grid[0][0] == 1 || grid[m-1][n-1] == 1)
            return -1;

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i< size; i++){
                int[] cur = q.poll();
                if(cur[0] == m-1 && cur[1] == n-1){
                    return res+1;
                }
                for(int k = 0; k < 8; k++) {
                    int x = cur[0] + dirs[k][0];
                    int y = cur[1] + dirs[k][1];
                    if(x >= 0 && x< m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {

                        q.add(new int[]{x,y});
                        visited[x][y] = true;
                    }
                }

            }
            res++;
        }
        return -1;
    }
}
