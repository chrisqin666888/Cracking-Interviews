package LeetCode.BFS.P286_Walls_and_Gates;
import java.util.*;

public class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = (m == 0) ? 0 : rooms[0].length;
        int[][] dirs ={{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int[] cur_position = queue.poll();
            for(int[] dir : dirs) {
                int X = cur_position[0] + dir[0];
                int Y = cur_position[1] + dir[1];
                if (X < 0 || Y < 0 || X >= m || Y >= n || rooms[X][Y] != Integer.MAX_VALUE) continue;
                rooms[X][Y] = rooms[cur_position[0]][cur_position[1]] + 1;
                queue.offer(new int[]{X, Y});
            }
        }
    }
}
