package LeetCode.Trie.P648_Replace_Words;
import java.util.*;

public class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Set<String> rootset = new HashSet<>();
        for(String root: dict) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        for (String word : sentence.split("\\s+")) {
            String prefix = "";
            for(int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(dict, sentence));
    }
}
