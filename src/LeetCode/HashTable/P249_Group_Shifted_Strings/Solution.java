package LeetCode.HashTable.P249_Group_Shifted_Strings;
import java.util.*;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strings) {
            String key = getKey(str);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        StringBuilder key = new StringBuilder();
        for(int i = 1; i < str.length(); i++) {
            int distance = str.charAt(i) - str.charAt(0);
            distance = distance >= 0 ? distance : distance + 26;
            key.append(distance).append(",");
        }
        return key.toString();
    }

    public static void main(String[] args) {
        String[] input = {"abc","bcd","acef","xyz","az","ba","a","z"};
        Solution solution = new Solution();
        System.out.println(solution.groupStrings(input));
    }
}
