package LeetCode.DFS_Graph.P721_Accounts_Merge;
import java.util.*;

public class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // key is an email nodes, the paired value set is its connected neighbor nodes
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> name = new HashMap<>();

        // Let's build the graph
        for(List<String> account : accounts) {
            // The first element is always the owner of accounts
            String userName = account.get(0);
            for(int i = 1; i < account.size(); i++) {
                // check if this email address one node of our graph
                // if not, add it to our graph and initialize an empty set for its neighbor nodes
                if (!graph.containsKey(account.get(i))) {
                    graph.put(account.get(i), new HashSet<>());
                }

                // afterwards, let's add the email address to the user
                name.put(account.get(i), userName);

                // when seeing the first account, it does not have previous neighbor so we skip it to next one
                if(i == 1) continue;
                // first part, get the neighbor nodes hashset
                // second part, add the previous email address as its neighbors
                graph.get(account.get(i)).add(account.get(i-1));
                // mutually add neighbors for previous email address
                graph.get(account.get(i-1)).add(account.get(i));
            }
        }
        Set<String> visited = new HashSet<>();
        List<List<String>> res = new LinkedList<>();

        // Start DFS the graph
        for(String email: name.keySet()) {
            List<String> tempList = new LinkedList<>();
            if (!visited.contains(email)) visited.add(email);
            else {
                dfs(graph, email, visited, tempList);
                Collections.sort(tempList);
                tempList.add(0, name.get(email));
                res.add(tempList);
            }
        }
        return res;
    }

    private void dfs(Map<String, Set<String>> graph, String email, Set<String> visited, List<String> tempList) {
        tempList.add(email);
        for(String next: graph.get(email)) {
            if (!visited.contains(next)) visited.add(next);
            dfs(graph, next, visited, tempList);

        }
    }
}
