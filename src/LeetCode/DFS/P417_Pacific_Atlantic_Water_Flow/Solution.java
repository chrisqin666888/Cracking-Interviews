package LeetCode.DFS.P417_Pacific_Atlantic_Water_Flow;
import java.util.*;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][]pacific = new boolean[m][n];
        boolean[][]atlantic = new boolean[m][n];
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, n-1);
        }
        for(int i=0; i<n; i++){
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, m-1, i);
        }
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (pacific[i][j] && atlantic[i][j])
                    res.add(Arrays.asList(i, j));
        return res;
    }

    public void dfs(int[][]matrix, boolean[][]visited, int height, int x, int y){
        int n = matrix.length, m = matrix[0].length;
        if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < height)
            return;
        visited[x][y] = true;
        dfs(matrix, visited, matrix[x][y], x - 1, y);
        dfs(matrix, visited, matrix[x][y], x + 1, y);
        dfs(matrix, visited, matrix[x][y], x, y - 1);
        dfs(matrix, visited, matrix[x][y], x, y + 1);
    }
}
