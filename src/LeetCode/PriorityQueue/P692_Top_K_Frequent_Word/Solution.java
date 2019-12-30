package LeetCode.PriorityQueue.P692_Top_K_Frequent_Word;
import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap<>();
        for(String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> heap = new PriorityQueue<>(
                (word1, word2) -> count.get(word1).equals(count.get(word2)) ?
                        word2.compareTo(word1) : count.get(word1) - count.get(word2)
        );

        for(String word: count.keySet()) {
            heap.offer(word);
            if(heap.size() > k) heap.poll();
        }

        List<String> ans = new ArrayList<>();
        while(!heap.isEmpty()) ans.add(heap.poll());
        Collections.reverse(ans);
        return ans;
    }
}
