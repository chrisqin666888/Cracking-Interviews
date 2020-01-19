package Interviews.Amazon.Word_Break;
import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);

        while(!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start] == 0) {
                for(int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }

        return false;
    }

    public boolean wordBreakDP(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>();
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "catsanddog";
        List<String> worddict = Arrays.asList("cat","cats","sand","and","dog");
        System.out.println(solution.wordBreak(s, worddict));
    }
}
