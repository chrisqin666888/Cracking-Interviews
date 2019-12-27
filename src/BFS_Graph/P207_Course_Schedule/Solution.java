package BFS_Graph.P207_Course_Schedule;
import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) return true;

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            if (graph.containsKey(prerequisite[1])) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);

                graph.put(prerequisite[1], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()) {
            int courseNum = queue.poll();
            List<Integer> subCourses = graph.get(courseNum);
            for(int i = 0; subCourses != null && i < subCourses.size(); i++) {
                if (--inDegree[subCourses.get(i)] == 0) queue.offer(subCourses.get(i));
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) return false;
        }

        return true;
    }
}
