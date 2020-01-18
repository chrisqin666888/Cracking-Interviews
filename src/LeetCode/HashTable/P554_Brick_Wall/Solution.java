package LeetCode.HashTable.P554_Brick_Wall;
import java.util.*;

public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0) return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list: wall) {
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }

        return wall.size() - count;
    }
}
