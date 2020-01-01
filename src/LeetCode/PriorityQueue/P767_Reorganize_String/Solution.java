package LeetCode.PriorityQueue.P767_Reorganize_String;
import java.util.*;

public class Solution {
    public String reorganizeString(String S) {
        // Create a map to count appearance of each char
        Map<Character, Integer> map = new HashMap<>();
        for(char c: S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
        }

        // push all map keys to a priority queue, by their frequency from highest to lowest
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue())
        );

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            heap.offer(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            // get the string with highest frequency in cache
            Map.Entry<Character, Integer> cache = heap.poll();

            // check if char in the current sb is same as char from the cache
            if (sb.length() == 0 || cache.getKey() != sb.charAt(sb.length() - 1)) {
                sb.append(cache.getKey());
                cache.setValue(cache.getValue() - 1);
            }
        }
    }
}
