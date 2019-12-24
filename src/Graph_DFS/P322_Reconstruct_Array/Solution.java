package Graph_DFS.P322_Reconstruct_Array;
import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> ticket : tickets) {
            if(!map.containsKey(ticket.get(0))) {
                PriorityQueue<String> heap = new PriorityQueue<>();
                map.put(ticket.get(0), heap);
            }

            map.get(ticket.get(0)).offer(ticket.get(1));
        }

        dfs("JFK", res, map);


        return res;
    }

    private void dfs(String s, LinkedList<String> res, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> q = map.get(s);
        while(q != null && !q.isEmpty()) {
            dfs(q.poll(), res, map);
        }

        res.addFirst(s);
    }

    public static void main(String[] args) {
        List<List<String>> input = Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ALT"),
                Arrays.asList("SFO", "ALT"),Arrays.asList("ALT", "JFK"), Arrays.asList("ALT", "SFO"));
        Solution s = new Solution();
        System.out.println(s.findItinerary(input));
    }
}
