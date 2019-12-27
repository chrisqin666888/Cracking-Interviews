package Array_Medium_Hard.P56_Merge_Intervals;
import java.util.*;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length == 0) return intervals;
        List<int[]> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++){
            if(ans.get(ans.size() - 1)[1] < intervals[i][0]) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};

        System.out.println(Arrays.deepToString(solution.merge(intervals)));
    }
}
